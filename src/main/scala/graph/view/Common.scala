package graph.view

import graph.global._
import scala.collection.mutable.ArrayBuffer
import graph.model._
import graph.lib._

class Common(model: TGraphModel, painting: FBGPainting ) {
  def redraw() = {
        clear()
        painting.expander.expandGraph(model)
        drawGraph()
  }
  def redraw_forLine() = {
        clear()
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
	  val draw =	(vertex:Vertex3D) => {
				  drawVertex(vertex)
				  if( Global.gLabels ) drawVertexLabel(vertex)
		}
		vertices.map(draw)
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