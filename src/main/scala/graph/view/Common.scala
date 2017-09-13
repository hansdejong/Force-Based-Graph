package graph.view

import graph.global._
import scala.collection.mutable.ArrayBuffer
import graph.drawings.EDrawings._
import graph.drawings.EDrawings
import graph.model._
import graph.view._
import graph.lib._
import org.scalajs.dom

class Common(model: TGraphModel, painting: FBGPainting ) {
  var lastFoundVertexIndex = -1
  var pressedAVertex = false
  
  //Deze routine ook gebruiken in wijzigmodel. Hernoemen en verplaatsen.
  //Dit was connectDragger
  def inspectCursorSpot(/*e: dom.MouseEvent, */pointCursor: Point2D):Unit = {
    painting.taAppendText ("Cursor "+ pointCursor.x + "," + pointCursor.y)
       var oneConnected:Boolean  = false
       var index = -1
       for (vertex3D <- model.vertices) {
         index=index+1 //beginnen bij 0
         if(model.VertexContains(vertex3D, pointCursor)){
           vertex3D.setDragged(true)
           oneConnected = true
           lastFoundVertexIndex = index
           }
         else
           vertex3D.setDragged(false)
       }
       //Dit er weer uit:
       for (vertex3D <- model.vertices; if(vertex3D.isDragged)) 
            painting.taText("raak")
       pressedAVertex = oneConnected
  }
  def redraw() = {
        clear()
        painting.expander.expandGraph(model)
        drawGraph()
  }
  private def clear() = {
        painting.canvasBgColor( "#f0F8ff")
  }
	//------------Tekenen van de graph------------------------------------------------------

	//wordt private
	private def drawGraph(/*model: TGraphModel*/):Unit = {
			val edges: Grid = model.edges
			val vertices: ArrayBuffer[Vertex3D] = model.vertices
			drawEdges(vertices, edges)
			drawVertices(vertices)
	}
	private def drawEdges(vertices:ArrayBuffer[Vertex3D], edges:Grid): Unit = {
			for (i <- 0 until vertices.size; j <- 0 until vertices.size) {
				if(edges.isConnected(i, j) ){
					val x1 = (vertices(i).getX() / Global.gZoom)
					val y1 = (vertices(i).getY() / Global.gZoom)
					val x2 = (vertices(j).getX() / Global.gZoom)
					val y2 = (vertices(j).getY() / Global.gZoom)
					painting.drawLine( x1, y1, x2, y2 )
				}
			}
	}
	private def drawVertices(vertices: ArrayBuffer[Vertex3D]): Unit = {
			for (vertex3D <- vertices) {
				drawVertex( vertex3D)
				drawVertexLabel( vertex3D)
			}
	}

	private def drawVertex( vertex: Vertex3D): Unit = {
			val xScreen: Double = vertex.getX / Global.gZoom
			val yScreen: Double = vertex.getY / Global.gZoom
			val color: String = vertex.color
			val label: String = vertex.label
			val r: Double = Vertex3D.radius / Global.gZoom
			painting.drawCircle(xScreen,yScreen,r, color)
	}

	private def drawVertexLabel( vertex: Vertex3D): Unit = {
			val xScreen: Double = vertex.getX / Global.gZoom
			val yScreen: Double = vertex.getY / Global.gZoom
			val txt = "" + xScreen + ", "+ yScreen
			painting.drawText(txt,xScreen+15,yScreen )
	}

}