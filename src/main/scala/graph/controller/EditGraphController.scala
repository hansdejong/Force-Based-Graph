package graph.controller


import graph.model._
import graph.lib._
import graph.global._
import org.scalajs.dom
import dom.html


//import java.awt.geom.Line2D

//import java.awt.geom.Point2D

import scala.collection.mutable.ArrayBuffer

import graph.model.Grid

import graph.model.TGraphModel

import graph.model.Vertex3D

//class EditGraphController(var model: TGraphModel) extends TGraphController {
class EditGraphController(var model: TGraphModel, cv:html.Canvas) extends{val canvas = cv }with TCanvas with TGraphController {
  
  
//  class FBGPaintingPanel(cv: html.Canvas, ta: html.TextArea) extends{
//  val canvas = cv
//  val textarea = ta
//} with TCanvas with TTextArea {
//Implementaties van traits --------------------------------------
  def onDragged(e: dom.MouseEvent){//add whatever
  }
  def onMoved(e: dom.MouseEvent){//add whatever
  }
  def onReleased(e: dom.MouseEvent) = {//add whatever
	}
  def onPressed(e: dom.MouseEvent) = {//add whatever
	}


//---------------------------------------------------------------  

// I can drag the new edge
  private var vertexIsChosen: Boolean = false

  private var vertexIsDragged: Boolean = false

  private var foundVertexPressed: Int = 0

  private var foundVertexReleased: Int = 0

  private var draggingCursor: Point2D = new Point2D(0, 0)

  def setVertexIsDragged(dragged: Boolean): Unit = {
    vertexIsDragged = dragged
  }

  def getVertexIsDraggedForEditing(): Boolean = vertexIsDragged

  def getDraggingLine(): Line2D =
    if (vertexIsDragged) {
      val vertices: ArrayBuffer[Vertex3D] = model.vertices
      val x1: Double = vertices(foundVertexPressed).getX
      val y1: Double = vertices(foundVertexPressed).getY
      val p1: Point2D = new Point2D(x1, y1)
      val p2: Point2D = draggingCursor
      new graph.lib.Line2D (p1, p2)
    } else null

  def onMouseIsPressed(leftButton: Boolean, pressedVertex: Int): Unit = {
    if (pressedVertex != -1) {
//Lib.melding("Vertex3D " + foundVertexPressed, "EditGraphController.mouseIsPressed");
      foundVertexPressed = pressedVertex
      vertexIsChosen = true
    }
  }

  def onMouseIsReleased(point: Point2D, releasedVertex: Int): Unit = {
    if (vertexIsDragged) {
      if (releasedVertex != -1) {
        foundVertexReleased = releasedVertex
        connectVertices()
      } else {
        makeVertex(point)
      }
      vertexIsDragged = false
      vertexIsChosen = false
    }
  }

  def onMouseIsDragged(point: Point2D): Unit = {
    if (vertexIsChosen) vertexIsDragged = true
    draggingCursor = point
  }

  def removeEdge(foundEdgeVertex1: Int, foundEdgeVertex2: Int): Unit = {
    model.removeEdge(foundEdgeVertex1, foundEdgeVertex2)
  }
//		Grid edges = model.getEdges();
//		edges.setConnected( foundEdgeVertex1, foundEdgeVertex2, false);
//		Grid edges = model.getEdges();
//		edges.setConnected( foundEdgeVertex1, foundEdgeVertex2, false);

  private def connectVertices(): Unit = {
    val edges: Grid = model.edges
    edges.setConnected(foundVertexPressed, foundVertexReleased, true)
  }

//Edges en vertices moeten naar het graphmodel-interface
  private def makeVertex(point: Point2D): Unit = {
    val vertices: ArrayBuffer[Vertex3D] = model.vertices
    val edges: Grid = model.edges
    val vertex3D: Vertex3D = new Vertex3D()
    vertex3D.setXYZ(point.x, point.y, 0)
    edges.setConnected(foundVertexPressed, vertices.size, true)
    vertices.append(vertex3D)
  }

}

