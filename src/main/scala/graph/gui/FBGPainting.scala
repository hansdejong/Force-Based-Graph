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
	private def setCanvasColor(kleur:String):Unit ={
			currentColor = kleur
	}
	private def getRandomDrawing(): EDrawings = {
			val graph = EDrawings(scala.util.Random.nextInt(EDrawings.maxId))
			taAppendText("\nGekozen Graph: "+ graph.toString())
			graph 
	}
	//val drawEdge = (edge: Edge) => {}
	//Meteen een drawEdges?
	def drawGraph(model: TGraphModel):Unit = {
	  	val edges: Grid = model.edges
	  //map(edges, drawEdge())

	    val vertices: ArrayBuffer[Vertex3D] = model.vertices
	    drawEdges(vertices, edges)
//

	}
  private def drawEdges(vertices:ArrayBuffer[Vertex3D], edges:Grid/*g2D: Graphics2D*/): Unit = {
//Lib.melding( edgesToString(),"ForceBasedGraphPaintingPanel.drawEdges");
//    g2D.setStroke(new BasicStroke(1))
//    g2D.setColor(new Color(0x333333))
    for (i <- 0 until vertices.size; j <- 0 until vertices.size) {
      if(edges.isConnected(i, j) ){
        val x1 = (vertices(i).getX() / zoom)
        val y1 = (vertices(i).getY() / zoom)
       	val x2 = (vertices(j).getX() / zoom)
     		val y2 = (vertices(j).getY() / zoom)
        drawLine( x1, y1, x2, y2 )
  }
//CONVERTER PROBLEEM
//                if(! edges.isConnected(i, j) ) continue;
//        		int x1 = (int)(vertices.get(i).getX() / zoom);
//        		int y1 = (int)(vertices.get(i).getY() / zoom);
//        		int x2 = (int)(vertices.get(j).getX() / zoom);
//        		int y2 = (int)(vertices.get(j).getY() / zoom);
//        		g2D.drawLine( x1, y1, x2, y2 );
  //}
    }
  }
	// //============Body logic ==============================================================
	private var graph:EDrawings = getRandomDrawing()
	private var model: TGraphModel =  new GraphModel( graph )
	drawGraph(model)
	
}

