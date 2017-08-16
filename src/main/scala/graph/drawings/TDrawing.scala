package graph.drawings

import java.util.ArrayList

import graph.model.Grid

import graph.model.Vertex3D

trait TDrawing {

  def getVertices(): ArrayList[Vertex3D]

  def getEdges(): Grid

}

