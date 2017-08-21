package graph.controller
//Kan zonder, maar gebruik als interface is netter
import graph.lib._

trait TGraphController {

  def getVertexIsDraggedForEditing(): Boolean

  def getDraggingLine(): Line2D

  def removeEdge(vertex1: Int, vertex2: Int): Unit

  //De controller heeft dus of een canvas nodig, of deze routines moeten naar FBGPaintingPanel
  
//on
  def onMouseIsPressed(leftButton: Boolean, foundVertex: Int): Unit

//on
  def onMouseIsReleased(point: Point2D, foundVertex: Int): Unit

//on
  def onMouseIsDragged(point: Point2D): Unit

}

