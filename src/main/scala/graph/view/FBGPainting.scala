package graph.view
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
import graph.view._
import graph.lib._
import org.scalajs.dom
import dom.html

class FBGPainting(cv: html.Canvas, ta: html.TextArea) extends
{ val canvas = cv; val textarea = ta } with TCanvas with TTextArea {
  private val rect = canvas.getBoundingClientRect()
  private var graph:EDrawings = getRandomDrawing()
  //var graph:EDrawings = EDrawings.STICK
  //var graph:EDrawings = EDrawings.CUBE //getRandomDrawing()
  private var model: TGraphModel =  new GraphModel( graph )
  private val dragger = new Dragger(model, this)
  private val changer = new Changer(model, this)

  val expander = new Expander(model, this)
  val common = new Common(model, this) 
  //val old = new Dismissed(model, this) 

	//============Method Declarations=======================================================
	private def getRandomDrawing(): EDrawings = {
			val graph = EDrawings(scala.util.Random.nextInt(EDrawings.maxId))
			taText("\nGekozen Graph: "+ graph.toString())
			graph 
	}
  def redraw():Unit = {//ook nodig voor StartGraph bij verandering zoom 
    common.redraw()
  }
  redraw()//I. Bij opstart
	//------------Mouse---------------------------------------------------------------------
  def onPressed(e: dom.MouseEvent) = {//add whatever
    var vertexConnected = false
    val xCursor: Double = (e.clientX - rect.left) * Global.gZoom
    val yCursor: Double = (e.clientY - rect.top) * Global.gZoom
    val pointCursor: Point2D = new Point2D(xCursor, yCursor)
    
    if (Global.gDraggingMode) {
      dragger.checkOnSpot(pointCursor)
      redraw() //II. Na elke klik
    }
      /*
      else{//Wijzigmode

      if (vertexConnected){
        val xy = changer.findVertexXY
        changer.startLine( xy.x.toInt, xy.y.toInt )
      }
      changer.inspectCursorSpot(pointCursor) //geldt voor alle acties//XXX
      vertexConnected = changer.pressedAVertex ///XXX
        //Ook een Edge kan worden aangewezen
        changer.removeEdgeIfFound(pointCursor)//zou moeten werken: changer III
      }
      //taText("\nDragging mode: "+ Global.gDraggingMode)
      //changer.makeNewVertex() //Beter naar dragging?
    }
      */
  }

  def onReleased(e: dom.MouseEvent) = {
    val rect = canvas.getBoundingClientRect()
    val xCursor: Double = (e.clientX - rect.left) * Global.gZoom
    val yCursor: Double = (e.clientY - rect.top) * Global.gZoom
    val pointCursor: Point2D = new Point2D(xCursor, yCursor)
    if (Global.gDraggingMode){
       //Niets
    } 
    /*
    else {//Wijzigmode
       changer.makeEdgeOrVertex(pointCursor)
       common.redraw()
    }
    */
  }


  def onDragged(e: dom.MouseEvent)
  {//add whatever
	    //Lijkt niet de juiste naamgeving
	    val xCursor: Double = (e.clientX -rect.left) * Global.gZoom //even zonder zoom
      val yCursor: Double = (e.clientY -rect.top) * Global.gZoom
      val pointCursor: Point2D = new Point2D(xCursor, yCursor)
     	if (Global.gDraggingMode ){
       	  //old.scratch(e)
          if( dragger.dragging ){ //XXX
       	    //// taText("voor "+ model) 
       	    dragger.dragVertex(xCursor.toInt, yCursor.toInt)
       	    common.redraw()
   	      }
     	  }
	      /*
     	  else{
 	     	  if( changer.pressedAVertex ){ //XXX
//       	  old.testDrawing()
        	  changer.dragLine(xCursor.toInt, yCursor.toInt)
      	    common.redraw()
      	    //changer.tryConnecting
     	    }
     	  }
     	  */
  }
  
	def onMoved(e: dom.MouseEvent){//add whatever
  }
  
	
}


