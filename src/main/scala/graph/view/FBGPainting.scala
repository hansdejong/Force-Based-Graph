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
  //val canvasTop = Global.canvasRect.top
  //val canvasLeft = Global.canvasRect.left
  //val zoom = 1 //TODO
  
  val rect = canvas.getBoundingClientRect()
  private var vertexIsChosen: Boolean = false
  private var vertexIsDragged: Boolean = false
  private var foundVertexPressed: Int = 0
  private var foundVertexReleased: Int = 0
  private var draggingCursor: Point2D = new Point2D(0, 0)
	

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
					drawLine( x1, y1, x2, y2 )
				}
			}
	}
	private def drawVertices(vertices: ArrayBuffer[Vertex3D]): Unit = {
			for (vertex3D <- vertices) {
				drawVertex( vertex3D)
				drawVertexLabel( vertex3D)
			}
	}

	def drawVertex( vertex: Vertex3D): Unit = {
			val xScreen: Double = vertex.getX / Global.gZoom
			val yScreen: Double = vertex.getY / Global.gZoom
			val color: String = vertex.color
			val label: String = vertex.label
			val r: Double = Vertex3D.radius / Global.gZoom
			drawCircle(xScreen,yScreen,r, color)
	}

	def drawVertexLabel( vertex: Vertex3D): Unit = {
			val xScreen: Double = vertex.getX / Global.gZoom
			val yScreen: Double = vertex.getY / Global.gZoom
			val txt = "" + xScreen + ", "+ yScreen
			drawText(txt,xScreen+15,yScreen )
	}
	
	//------------Mouse---------------------------------------------------------------------
	def onDragged(e: dom.MouseEvent)
  {//add whatever
	    	//Lijkt niet de juiste naamgeving
	      val xCursor: Double = (e.clientX -rect.left) * Global.gZoom //even zonder zoom
        val yCursor: Double = (e.clientY -rect.top) * Global.gZoom
        val pointCursor: Point2D = new Point2D(xCursor, yCursor)
   	 // scratch(e)
//taText("left "+ rect.left+ ", top " + rect.top)
   	  //Het volgende werkt niet
   	  ///taAppendText("Vertex hit:" + commonActions.pressedAVertex)
   	  if( commonActions.pressedAVertex ){
     	  if (Global.gDraggingMode ){
     	   //// taText("voor "+ model) 
     	    dragger.dragVertex(xCursor.toInt, yCursor.toInt)
      	  testDrawing()
       	  //nog eens proberen
  	      //expander.expandGraph(model)//Doet het (hier) niet
     	    drawGraph()
  
     	    //taText("left "+ rect.left+ ", top " + rect.top)//19,95
  
     	    /////taAppendText("na "+ model)
     	  }
     	  else{
     	    testDrawing()
       	  changer.dragLine(xCursor.toInt, yCursor.toInt)
     	    drawGraph()
     	    //changer.tryConnecting
     	  }
   	  }
  }
  
	def onMoved(e: dom.MouseEvent){//add whatever
  }
  
  def onReleased(e: dom.MouseEvent) = {//add whatever
    val rect = canvas.getBoundingClientRect()
    ////  override def mouseReleased(event: MouseEvent): Unit = {
    val xCursor: Double = (e.clientX - rect.left) * Global.gZoom
    val yCursor: Double = (e.clientY - rect.top) * Global.gZoom
    val pointCursor: Point2D = new Point2D(xCursor, yCursor)
//Lib.melding("Omhoog: " + x + ", " + y, "ForceBasedGraphPaintingPanel.mouseReleased");
 if (Global.gDraggingMode){////    if (draggingMode) {
       //dragger.releaseDragger()
    } else {
       changer.makeEdgeOrVertex(pointCursor)
    }
//////Lib.melding( "Release before recalc ", "ForceBasedGraphPaintingPanel.mouseReleased");
//////Lib.melding( "Release before recalc ", "ForceBasedGraphPaintingPanel.mouseReleased");
////    recalcGraphAsNeeded()
  }

//  }

	
  def onPressed(e: dom.MouseEvent) = {//add whatever
      //////mouseListener = new MouseAdapter(){
////  def mousePressed(event: MouseEvent): Unit = {
    var vertexConnected = false
    val xCursor: Double = (e.clientX - rect.left) * Global.gZoom
    val yCursor: Double = (e.clientY - rect.top) * Global.gZoom
    //TODO
    val pointCursor: Point2D = new Point2D(xCursor, yCursor)
////showPoints( pointModel/*, point*/);//TODO, magweg
    commonActions.inspectCursorSpot(pointCursor) //geldt voor alle acties
    vertexConnected = commonActions.pressedAVertex
    if (!Global.gDraggingMode) {
      if (vertexConnected){
        val xy = changer.findVertexXY
        changer.startLine( xy.x.toInt, xy.y.toInt )
      }
      else{
        //Ook een Edge kan worden aangewezen
        changer.removeEdgeIfFound(pointCursor)//zou moeten werken: changer III
      }
      
       
      taText("\nDragging mode: "+ Global.gDraggingMode)
      
      changer.makeNewVertex() //Beter naar dragging?
    }
  }
    
    
    
    //  def onMouseIsPressed(leftButton: Boolean, pressedVertex: Int): Unit = {
//    if (pressedVertex != -1) {
////Lib.melding("Vertex3D " + foundVertexPressed, "EditGraphController.mouseIsPressed");
//      foundVertexPressed = pressedVertex
//      vertexIsChosen = true
//    }
//  }
//	}

  

  
  
  
  
  ////
//////mouseMotionListener = new MouseMotionAdapter(){
////  def mouseDragged(event: MouseEvent): Unit = {
////    val xModel: Double = event.getX * zoom
////    val yModel: Double = event.getY * zoom
////    val pointModel: Point2D.Double = new Point2D.Double(xModel, yModel)
////    if (draggingMode) {
//////Lib.melding("Slepen: " + x + ", " + y, "ForceBasedGraphPaintingPanel.mouseDragged");
////      dragVertex(xModel.toInt, yModel.toInt)
////    } else {
////      graphController.onMouseIsDragged(pointModel)
////    }
////    repaint()
////  }

// private var vertexIsChosen: Boolean = false
//
//  private var vertexIsDragged: Boolean = false
//
//  private var foundVertexPressed: Int = 0
//
//  private var foundVertexReleased: Int = 0
//
//  private var draggingCursor: Point2D = new Point2D(0, 0)
//  
//    def setVertexIsDragged(dragged: Boolean): Unit = {
//    vertexIsDragged = dragged
//  }
//
//  def getVertexIsDraggedForEditing(): Boolean = vertexIsDragged
//

//
//
//  def onMouseIsDragged(point: Point2D): Unit = {
//    if (vertexIsChosen) vertexIsDragged = true
//    draggingCursor = point
//  }
//
//  def removeEdge(foundEdgeVertex1: Int, foundEdgeVertex2: Int): Unit = {
//    model.removeEdge(foundEdgeVertex1, foundEdgeVertex2)
//  }
////		Grid edges = model.getEdges();
////		edges.setConnected( foundEdgeVertex1, foundEdgeVertex2, false);
////		Grid edges = model.getEdges();
////		edges.setConnected( foundEdgeVertex1, foundEdgeVertex2, false);
//
//  private def connectVertices(): Unit = {
//    val edges: Grid = model.edges
//    edges.setConnected(foundVertexPressed, foundVertexReleased, true)
//  }
//
////Edges en vertices moeten naar het graphmodel-interface
//  private def makeVertex(point: Point2D): Unit = {
//    val vertices: ArrayBuffer[Vertex3D] = model.vertices
//    val edges: Grid = model.edges
//    val vertex3D: Vertex3D = new Vertex3D()
//    vertex3D.setXYZ(point.x, point.y, 0)
//    edges.setConnected(foundVertexPressed, vertices.size, true)
//    vertices.append(vertex3D)
//  }

	//------------Force expansion-----------------------------------------------------------

	//------------Slepen van de graph-------------------------------------------------------
	//------------Veranderen van de graph---------------------------------------------------

  
  //------------Tijdelijk. Scratchpad en testDrawing--------------------------------------
  def dummy = {}
  def scratch(e: dom.MouseEvent) = {
  	  context.fillStyle = Global.gColor
  		val rect = canvas.getBoundingClientRect()
  		context.fillRect( e.clientX - rect.left, e.clientY - rect.top, 10, 10)
  }
  testDrawing()
  def testDrawing() ={
    canvasBgColor( "#a6F611")
    //canvasBgColor( "pink")
    drawText("Hallo allemaal",10,50)
    drawCircle(95,80,40, "yellow")
    paintface()
    drawLine(150,250, 130,160)
    drawLine (0 ,0 , canvasWidth, canvasHeight)
  }
  def paintface()={    
  		val w = 300
  		context.strokeStyle = "purple"
  		context.lineWidth = 3
  		context.beginPath()
  		context.moveTo(w/3, 0)
  		context.lineTo(w/3, w/3)
  		context.moveTo(w*2/3, 0)
  		context.lineTo(w*2/3, w/3)
  		context.moveTo(w, w/2)
  		context.arc(w/2, w/2, w/2, 0, 3.14)
  		context.stroke()
  } 
	//============Body logic ===============================================================
  
  //waarschijnlijk kan Expander een object blijven, maar dit is
  //gemakkelijker en consistenter 
	
  var graph:EDrawings = getRandomDrawing()
  //var graph:EDrawings = EDrawings.STICK
  //var graph:EDrawings = EDrawings.CUBE //getRandomDrawing()
  
  private var model: TGraphModel =  new GraphModel( graph )
			drawGraph(/*model*/)
  val dragger = new Dragger(model, this)
  val changer = new Changer(model, this)
  val expander = new Expander(model, this)
  val commonActions = new CommonActions(model, this)
			
//Expander doet niets 
//			//			Thread.sleep(1000)
//			import scala.scalajs.js.timers._
//setTimeout(1000) { // note the absence of () =>
//  // work

			var v=model.vertices(1);
			val extra:Int =50
        v.location.x =v.location.x + extra
        v.location.y =v.location.y + extra
        v.location.z =v.location.z + extra
		//	model = 
			  expander.expandGraph(model)//kan wellicht zonder assignment
			drawGraph(/*model*/)
}


