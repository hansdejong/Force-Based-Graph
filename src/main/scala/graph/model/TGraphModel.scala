package graph.model

import graph.lib._

import scala.collection.mutable.ArrayBuffer

trait TGraphModel  {

  var vertices: ArrayBuffer[Vertex3D]

//Kan Grid ook een list of map worden? Of beter alleen methods op vertices of edges
  var edges: Grid

  def VertexContains(vertex: Vertex3D, point: Point2D): Boolean

  def findFirstVertex(point: Point2D): Int


}

