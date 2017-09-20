package graph.view

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
import dom.document
import dom.html

class FBGPainting(cv: html.Canvas, ta: html.TextArea) extends
{ val canvas = cv; val textarea = ta } with TCanvas with TTextArea {
  private var graph:EDrawings = getRandomDrawing()
  //var graph:EDrawings = EDrawings.STICK
  //var graph:EDrawings = EDrawings.CUBE
  //var graph:EDrawings = EDrawings.DOUGHNUT
  //var graph:EDrawings = EDrawings.RANDOM
  private var model: TGraphModel =  new GraphModel( graph )
  private val dragger = new Dragger(model, this)
  private val changer = new Changer(model, this)

  val expander = new Expander(model, this)
  val common = new Common(model, this) 

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
    val rect = canvas.getBoundingClientRect()
    var vertexConnected = false
    val xCursor: Double = (e.clientX - rect.left) * Global.gZoom
    val yCursor: Double = (e.clientY - rect.top) * Global.gZoom
    val pointCursor: Point2D = new Point2D(xCursor, yCursor)
    
    if (Global.gDraggingMode) {
      dragger.checkOnSpot(pointCursor)
      redraw() //II. Na elke klik
      Global.appendMsg( "FBGPainting.onPressed "+ toString() )
    }
    else{//Wijzigmode
      changer.inspectCursorSpot(pointCursor)
      vertexConnected = changer.pressedAVertex
      if (vertexConnected){
        val xy = changer.findDraggedVertexXY //nu niet pointCursor gebruiken
        changer.startLine( (xy.x / Global.gZoom).toInt, (xy.y / Global.gZoom).toInt )
      }else{//Ook een Edge kan worden aangewezen
        changer.removeEdgeIfFound(pointCursor)
        redraw() //III. Na verwijderen edge
      }
    }
  }

  def onDragged(e: dom.MouseEvent)
  {
      val rect = canvas.getBoundingClientRect()
	    //Lijkt niet de juiste naamgeving
	    val xCursor: Double = (e.clientX -rect.left) * Global.gZoom //even zonder zoom
      val yCursor: Double = (e.clientY -rect.top) * Global.gZoom
      val pointCursor: Point2D = new Point2D(xCursor, yCursor)
     	if (Global.gDraggingMode ){
       	  //old.scratch(e)
          if( dragger.dragging ){ //XXX
       	    dragger.dragVertex(xCursor.toInt, yCursor.toInt)
       	    redraw() //IV. Bij verplaatsen
   	      }
     	  }
     	  else{//wijzigmode
 	     	  if( changer.pressedAVertex ){
     	      common.redraw_forLine()//V. Na tekenen lijn
       	    changer.dragLine((xCursor / Global.gZoom).toInt, (yCursor / Global.gZoom).toInt)
     	    }
     	  }
  }
  
  def onReleased(e: dom.MouseEvent) = {
    val rect = canvas.getBoundingClientRect()
    val xCursor: Double = (e.clientX - rect.left) * Global.gZoom
    val yCursor: Double = (e.clientY - rect.top) * Global.gZoom
    val pointCursor: Point2D = new Point2D(xCursor, yCursor)
    if (Global.gDraggingMode){
       //Niets
    } 
    else {//Wijzigmode
       if(changer.pressedAVertex){
         changer.makeEdgeOrVertex(pointCursor)
         changer.pressedAVertex = false
         redraw() //VI. Na verandering
       }
    }
  }


	def onMoved(e: dom.MouseEvent){//add whatever
  }
	
	//Om de oorzaak van de instabiliteit uit te vissen.
	//Voorlopig streven de situatie qua toestandsvariabelen weer te geven.
	override def toString = {
	  val toestand = 
	    if(Global.gDraggingMode){
	      if(dragger.dragging)
	        "Dragging, connected"
	      else
	        "Dragging, not connected"
	     }
	  
	    else{
	      if(changer.pressedAVertex) 
	        "Changing, connected"
	      else
	        "Changing, not connected"
	    }
	  toestand + " "
	}
}


