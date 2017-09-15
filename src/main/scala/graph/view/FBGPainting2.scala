//package graph.view
///**Ik wil hier opniew een painting opbouwen
// * De controller bevatte nauwelijks basis routines (sec reageren op muiw en zo)
// * Ik begin zonder link naar de controller en kopieer wat ik nodig heb
// * later kan ik altijd nog van alles asplitsen naar hulp klassen of traits
// * 
// */
//
//import graph.global._
//import scala.collection.mutable.ArrayBuffer
//import graph.drawings.EDrawings._
//import graph.drawings.EDrawings
//import graph.model.GraphModel
//import graph.model.Edge
//import graph.model.Grid
//import graph.model.TGraphModel
//import graph.model.Vertex3D
//import graph.view._
//import graph.lib._
//import org.scalajs.dom
//import dom.html
//
//class FBGPainting(cv: html.Canvas, ta: html.TextArea) extends
//{ val canvas = cv; val textarea = ta } with TCanvas with TTextArea {
//  private val rect = canvas.getBoundingClientRect()
//  private var graph:EDrawings = getRandomDrawing()
//  //var graph:EDrawings = EDrawings.STICK
//  //var graph:EDrawings = EDrawings.CUBE //getRandomDrawing()
//  private var model: TGraphModel =  new GraphModel( graph )
//  private val dragger = new Dragger(model, this)
//  private val changer = new Changer(model, this)
//
//  val expander = new Expander(model, this)
//  val common = new Common(model, this) 
//  //val old = new Dismissed(model, this) 
//
//	//============Method Declarations=======================================================
//	private def getRandomDrawing(): EDrawings = {
//			val graph = EDrawings(scala.util.Random.nextInt(EDrawings.maxId))
//			taText("\nGekozen Graph: "+ graph.toString())
//			graph 
//	}
//  def redraw():Unit = {
//    common.redraw()
//  }
//  redraw()
//	//------------Mouse---------------------------------------------------------------------
//	def onDragged(e: dom.MouseEvent)
//  {//add whatever
//	    	//Lijkt niet de juiste naamgeving
//	      val xCursor: Double = (e.clientX -rect.left) * Global.gZoom //even zonder zoom
//        val yCursor: Double = (e.clientY -rect.top) * Global.gZoom
//        val pointCursor: Point2D = new Point2D(xCursor, yCursor)
//   	  //old.scratch(e)
////taText("left "+ rect.left+ ", top " + rect.top)
//   	  //Het volgende werkt niet
//   	  ///taAppendText("Vertex hit:" + common.pressedAVertex)
//   	  if( changer.pressedAVertex ){ //XXX
//     	  if (Global.gDraggingMode ){
//     	   //// taText("voor "+ model) 
//     	    dragger.dragVertex(xCursor.toInt, yCursor.toInt)
//      	  //old.testDrawing()
//       	  //nog eens proberen
//  	      //expander.expandGraph(model)//Doet het (hier) niet
//     	    common.redraw()
//  
//     	    //taText("left "+ rect.left+ ", top " + rect.top)//19,95
//  
//     	    /////taAppendText("na "+ model)
//     	  }
//     	  else{
////       	  old.testDrawing()
//       	  changer.dragLine(xCursor.toInt, yCursor.toInt)
//     	    common.redraw()
//     	    //changer.tryConnecting
//     	  }
//   	  }
//	    
//  }
//  
//	def onMoved(e: dom.MouseEvent){//add whatever
//  }
//  
//  def onReleased(e: dom.MouseEvent) = {//add whatever
//    val rect = canvas.getBoundingClientRect()
//    val xCursor: Double = (e.clientX - rect.left) * Global.gZoom
//    val yCursor: Double = (e.clientY - rect.top) * Global.gZoom
//    val pointCursor: Point2D = new Point2D(xCursor, yCursor)
//    if (Global.gDraggingMode){
//       //Niets
//    } else {
//       changer.makeEdgeOrVertex(pointCursor)
//       common.redraw()
//    }
//  }
//
//	
//  def onPressed(e: dom.MouseEvent) = {//add whatever
//    var vertexConnected = false
//    val xCursor: Double = (e.clientX - rect.left) * Global.gZoom
//    val yCursor: Double = (e.clientY - rect.top) * Global.gZoom
//    //TODO
//    val pointCursor: Point2D = new Point2D(xCursor, yCursor)
//    changer.inspectCursorSpot(pointCursor) //geldt voor alle acties//XXX
//    vertexConnected = changer.pressedAVertex ///XXX
//    if (!Global.gDraggingMode) {
//      if (vertexConnected){
//        val xy = changer.findVertexXY
//        changer.startLine( xy.x.toInt, xy.y.toInt )
//      }
//      else{
//        //Ook een Edge kan worden aangewezen
//        changer.removeEdgeIfFound(pointCursor)//zou moeten werken: changer III
//      }
//      //taText("\nDragging mode: "+ Global.gDraggingMode)
//      //changer.makeNewVertex() //Beter naar dragging?
//    }
//  }
//}
//
//
