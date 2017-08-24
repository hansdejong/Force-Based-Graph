package graph.gui
/**Ik wil hier opniew een painting opbouwen
 * De controller bevatte nauwelijks basis routines (sec reageren op muiw en zo)
 * Ik begin zonder link naar de controller en kopieer wat ik nodig heb
 * later kan ik altijd nog van alles asplitsen naar hulp klassen of traits
 * 
 */

import graph.global._
import scala.collection.mutable.ArrayBuffer
import graph.drawings.EDrawings._
import graph.drawings.EDrawings
import graph.model.GraphModel
import graph.model.Edge
import graph.model.Grid
import graph.model.TGraphModel
import graph.model.Vertex3D
import org.scalajs.dom
import dom.html

class FBGPainting(cv: html.Canvas, ta: html.TextArea) extends
{ val canvas = cv; val textarea = ta } with TCanvas with TTextArea {
	val zoom = 1 //TODO
	//============Method Declarations=======================================================
	//------------Tekenen van de graph------------------------------------------------------
	private def setCanvasColor(kleur:String):Unit ={
			currentColor = kleur
	}
	private def getRandomDrawing(): EDrawings = {
			val graph = EDrawings(scala.util.Random.nextInt(EDrawings.maxId))
			taText("\nGekozen Graph: "+ graph.toString())
			graph 
	}

	private def drawGraph(model: TGraphModel):Unit = {
			val edges: Grid = model.edges
			val vertices: ArrayBuffer[Vertex3D] = model.vertices
			drawEdges(vertices, edges)
			drawVertices(vertices)
	}
	private def drawEdges(vertices:ArrayBuffer[Vertex3D], edges:Grid): Unit = {
			for (i <- 0 until vertices.size; j <- 0 until vertices.size) {
				if(edges.isConnected(i, j) ){
					val x1 = (vertices(i).getX() / zoom)
					val y1 = (vertices(i).getY() / zoom)
					val x2 = (vertices(j).getX() / zoom)
					val y2 = (vertices(j).getY() / zoom)
					drawLine( x1, y1, x2, y2 )
				}
			}
	}
	private def drawVertices(vertices: ArrayBuffer[Vertex3D]): Unit = {
			for (vertex3D <- vertices) {
				drawVertex( vertex3D)
			}
	}

	def drawVertex( vertex: Vertex3D): Unit = {
			val xScreen: Double = vertex.getX / zoom
			val yScreen: Double = vertex.getY / zoom
			val color: String = vertex.color
			val label: String = vertex.label
			val r: Double = Vertex3D.radius / zoom
			//    if (drawWithLabels) {
			//      ctx.drawString(label, xScreen.toInt + 15, yScreen.toInt)
			//    }
			drawCircle(xScreen,yScreen,r, color)
	}
	//------------Force expansion-----------------------------------------------------------
	//------------Slepen van de graph-------------------------------------------------------
	//------------Veranderen van de graph---------------------------------------------------

	//============Body logic ===============================================================
	private var graph:EDrawings = getRandomDrawing()
			private var model: TGraphModel =  new GraphModel( graph )
			drawGraph(model)

}

