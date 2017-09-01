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
import graph.gui._
import graph.lib._
import org.scalajs.dom
import dom.html

class FBGPainting(cv: html.Canvas, ta: html.TextArea) extends
{ val canvas = cv; val textarea = ta } with TCanvas with TTextArea {
  //val canvasTop = Global.canvasRect.top
  //val canvasLeft = Global.canvasRect.left
  val zoom = 1 //TODO
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
				drawVertexLabel( vertex3D)
			}
	}

	def drawVertex( vertex: Vertex3D): Unit = {
			val xScreen: Double = vertex.getX / zoom
			val yScreen: Double = vertex.getY / zoom
			val color: String = vertex.color
			val label: String = vertex.label
			val r: Double = Vertex3D.radius / zoom
			drawCircle(xScreen,yScreen,r, color)
	}

	def drawVertexLabel( vertex: Vertex3D): Unit = {
			val xScreen: Double = vertex.getX / zoom
			val yScreen: Double = vertex.getY / zoom
			val txt = "" + xScreen + ", "+ yScreen
			drawText(txt,xScreen+15,yScreen )
	}
	
	//------------Mouse---------------------------------------------------------------------
	  def onDragged(e: dom.MouseEvent)
  {//add whatever
	    	
	      val xModel: Double = (e.clientX -rect.left) * zoom //even zonder zoom
        val yModel: Double = (e.clientY -rect.top) * zoom
        val pointModel: Point2D = new Point2D(xModel, yModel)
   	  scratch(e)
//taText("left "+ rect.left+ ", top " + rect.top)
   	  if (Global.gDraggingMode){
   	   //// taText("voor "+ model) 
   	    dragger.dragVertex(xModel.toInt, yModel.toInt)
   	    taText("left "+ rect.left+ ", top " + rect.top)//19,95

   	    /////taAppendText("na "+ model)
   	  }
   	  else
   	    changer.tryConnecting
   	  testDrawing()
   	  drawGraph()
  }
  def onMoved(e: dom.MouseEvent){//add whatever
  }
  def onReleased(e: dom.MouseEvent) = {//add whatever
    val rect = canvas.getBoundingClientRect()
    ////  override def mouseReleased(event: MouseEvent): Unit = {
    val xModel: Double = (e.clientX - rect.left) * zoom
    val yModel: Double = (e.clientY - rect.top) * zoom
    val pointModel: Point2D = new Point2D(xModel, yModel)
//Lib.melding("Omhoog: " + x + ", " + y, "ForceBasedGraphPaintingPanel.mouseReleased");
 if (Global.gDraggingMode){////    if (draggingMode) {
       dragger.releaseDragger()
    } else {
       changer.makeNewVertex()
    }
//////Lib.melding( "Release before recalc ", "ForceBasedGraphPaintingPanel.mouseReleased");
//////Lib.melding( "Release before recalc ", "ForceBasedGraphPaintingPanel.mouseReleased");
////    recalcGraphAsNeeded()
  }

//  }

	
  def onPressed(e: dom.MouseEvent) = {//add whatever
      //////mouseListener = new MouseAdapter(){
////  def mousePressed(event: MouseEvent): Unit = {
    val xModel: Double = (e.clientX - rect.left) * zoom
    val yModel: Double = (e.clientY - rect.top) * zoom
    //TODO
    val pointModel: Point2D = new Point2D(xModel, yModel)
////showPoints( pointModel/*, point*/);//TODO, magweg
    if (Global.gDraggingMode) {
      dragger.connectDragger(pointModel)
    } else {
      changer.makeNewVertex()
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
//  def getDraggingLine(): Line2D =
//    if (vertexIsDragged) {
//      val vertices: ArrayBuffer[Vertex3D] = model.vertices
//      val x1: Double = vertices(foundVertexPressed).getX
//      val y1: Double = vertices(foundVertexPressed).getY
//      val p1: Point2D = new Point2D(x1, y1)
//      val p2: Point2D = draggingCursor
//      new graph.lib.Line2D (p1, p2)
//    } else null
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
	
  //var graph:EDrawings = getRandomDrawing()
  var graph:EDrawings = EDrawings.STICK
  //var graph:EDrawings = EDrawings.CUBE //getRandomDrawing()
  private var model: TGraphModel =  new GraphModel( graph )
			drawGraph(/*model*/)
  val dragger = new Dragger(model,this)
  val changer = new Changer(model)
  val expander = new Expander(model)
			
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


