package graph.view

import graph.model._
import graph.lib._
import graph.global._

/**
 * Wijzigmode
 * I. Een vertex wordt gesleept en losgelaten op een andere vertex => verbindingsedge
 * II. Een vertex wordt gesleept en losgelaten in leeg terrein => nieuwe, verbonden vertex
 * III- Een edge wordt aangeklikt => edge verdwijnt
 * */
class Changer ( model: TGraphModel, writer: FBGPainting ) {
  var x = 0.0; var y = 0.0
  //onPressed A
  def findVertexXY(): Point2D = {
    var default = new Point2D()
    for (i <- 0 until model.vertices.size) {
      var v: Vertex3D = model.vertices(i)
      if (v.isDragged){
        var x: Int = v.getX
        var y: Int = v.getY
        default = new Point2D(x,y)
      }
    }
    default
   }
  //onPressed B
  def startLine( xCursor: Int, yCursor: Int) = {
    x = xCursor; y = yCursor
  }
  //onDragged
  def dragLine( xCursor: Int, yCursor: Int): Unit = {
    writer.drawLine(x,y,xCursor, yCursor)
  }
  //onReleased A (niet op andere vertex)
  def makeNewVertex() ={
  //////is al maal zoom
  ////      val foundVertex: Int = model.findFirstVertex(pointCursor)
  ////      graphController.onMouseIsReleased(pointCursor, foundVertex)
   
  }
  //onReleased A (wel op andere vertex)
  def makeEdgeOrVertex(xy: Point2D) ={
    val vertex1 = writer.common.lastFoundVertexIndex
    writer.common.inspectCursorSpot(xy)
    if( writer.common.pressedAVertex ){
      //edge tussen twee vertices
      val vertex2 = writer.common.lastFoundVertexIndex
      model.edges.setConnected(vertex1,vertex2,true)
      writer.taAppendText("Connected " + vertex1 + " en " + vertex2)
    }
    else
    {
      //Nieuwe vertex, verbonden met vertrekpunt
      val edges: Grid = model.edges
//      val vertex3D: Vertex3D = new Vertex3D()
      val vertex3D: Vertex3D = new Vertex3D(Global.gColor)
      vertex3D.setXYZ(xy.x, xy.y, 0)
      edges.setConnected(vertex1, model.vertices.size, true)
      model.vertices.append(vertex3D) 
      //OK maar werkt scherm niet meteen bij 
      
    }
  }
      //  def onMouseIsReleased(point: Point2D, releasedVertex: Int): Unit = {
//    if (vertexIsDragged) {
//      if (releasedVertex != -1) {
//        foundVertexReleased = releasedVertex
//        connectVertices()
//      } else {
//        makeVertex(point)
//      }
//      vertexIsDragged = false
//      vertexIsChosen = false
//    }
  
  
  //      val leftButton: Boolean = (event.getModifiers == InputEvent.BUTTON1_MASK)
//      val foundVertex: Int = model.findFirstVertex(pointCursor)
//      if (foundVertex != -1) {
//        if (!leftButton) {
////Lib.melding( "RechterMuisknop", "ForceBasedGraphPaintingPanel.mousePressed()" );
//          model.setVertexColor(foundVertex, defaultVertexColor)
//        } else {
//          graphController.onMouseIsPressed(leftButton, foundVertex)
//        }
//      } else if (model.findEdge(pointCursor)) {
//        graphController.removeEdge(model.getLastFoundEdgeVertex1,
//                                   model.getLastFoundEdgeVertex2)
//      }

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
  def tryConnecting() = {}
  //=============================================================
  // III doet het nu (verwijderen edge): 
  def removeEdgeIfFound(point: Point2D): Unit = {
    for (i <- 0 until model.vertices.size; j <- 0 until model.vertices.size) {
      if (  model.edges.isConnected(i, j) && edgeContains(point, i, j) ) {
          model.edges.setConnected(i,j, false)
          return
        }
    }
  }

  private def edgeContains(point: Point2D, v1: Int, v2: Int): Boolean = {
    val vtx1: Vertex3D = model.vertices(v1)
    val vtx2: Vertex3D = model.vertices(v2)
    val x1: Double = vtx1.getX
    val y1: Double = vtx1.getY
    val x2: Double = vtx2.getX
    val y2: Double = vtx2.getY
    if( FBGLib.onLine(point.x, point.y, x1, y1, x2, y2))true else false
  }

  

}