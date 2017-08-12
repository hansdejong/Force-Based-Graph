package graph.controller

import java.awt.geom.Line2D

import java.awt.geom.Point2D

trait TGraphController {

  def getVertexIsDraggedForEditing(): Boolean

  def getDraggingLine(): Line2D.Double

  def removeEdge(vertex1: Int, vertex2: Int): Unit

//on
  def onMouseIsPressed(leftButton: Boolean, foundVertex: Int): Unit

//on
  def onMouseIsReleased(point: Point2D.Double, foundVertex: Int): Unit

//on
  def onMouseIsDragged(point: Point2D.Double): Unit

}

