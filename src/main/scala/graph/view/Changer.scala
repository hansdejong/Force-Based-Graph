package graph.view

import graph.model._
import graph.lib._
import graph.global._
//Laat de redraw-commando´s in FBGPainting

/**
 * Wijzigmode
 * I. Een vertex wordt gesleept en losgelaten op een andere vertex => verbindingsedge
 * II. Een vertex wordt gesleept en losgelaten in leeg terrein => nieuwe, verbonden vertex
 * III- Een edge wordt aangeklikt => edge verdwijnt
 * */
class Changer ( model: TGraphModel, writer: FBGPainting ) {
  var x = 0.0; var y = 0.0
  var lastFoundVertexIndex = -1
  var pressedAVertex = false
  
  //Deze routine ook gebruiken in wijzigmodel. Hernoemen en verplaatsen.
  //Dit was connectDragger
  def inspectCursorSpot(/*e: dom.MouseEvent, */pointCursor: Point2D):Unit = {
       //painting.taAppendText ("Cursor "+ pointCursor.x + "," + pointCursor.y)
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
       //for (vertex3D <- model.vertices; if(vertex3D.isDragged)){ 
            //painting.taText("raak")
       //}
       pressedAVertex = oneConnected
  }

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
    writer.taAppendText("StartLine op " + xCursor+","+yCursor)
  }
  //onDragged
  def dragLine( xCursor: Int, yCursor: Int): Unit = {
    writer.drawLine(x,y,xCursor, yCursor)
    writer.taAppendText("DragLine " + x + "," + y + " naar " + xCursor+","+yCursor)
  }

  def makeEdgeOrVertex(xy: Point2D) ={
    val vertex1 = lastFoundVertexIndex
    inspectCursorSpot(xy)
    if( pressedAVertex ){
      //edge tussen twee vertices
      val vertex2 = lastFoundVertexIndex
      model.edges.setConnected(vertex1,vertex2,true)
      //writer.taAppendText("Connected " + vertex1 + " en " + vertex2)
    }
    else
    {
      //Nieuwe vertex, verbonden met vertrekpunt
      val edges: Grid = model.edges
      val vertex3D: Vertex3D = new Vertex3D(Global.gColor)
      vertex3D.setXYZ(xy.x, xy.y, 0)
      edges.setConnected(vertex1, model.vertices.size, true)
      model.vertices.append(vertex3D) 
      //OK maar werkt scherm niet meteen bij 
      
    }
  }

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