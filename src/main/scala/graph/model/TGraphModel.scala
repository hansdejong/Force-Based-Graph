package graph.model

import java.awt.Color

import java.awt.geom.Point2D

import scala.collection.mutable.ArrayBuffer

trait TGraphModel  {

  var vertices: ArrayBuffer[Vertex3D]

//Kan Grid ook een list of map worden? Of beter alleen methods op vertices of edges
  var edges: Grid

  //def setVertexColor(vertex: Int, vertexColor: Color): Unit
  //def vertexColor:( vertex: Int, vertexColor: Color) //Snap ik even niet

//int voor de vertex?
  def VertexContains(vertex: Vertex3D, point: Point2D.Double): Boolean

  def findFirstVertex(point: Point2D.Double): Int

//Blijft over
  def removeEdge(vertex1: Int, vertex2: Int): Unit

//Moet weg
  def findEdge(point: Point2D.Double): Boolean

//Moet weg
  def getLastFoundEdgeVertex1(): Int

//Moet weg
  def getLastFoundEdgeVertex2(): Int

}

