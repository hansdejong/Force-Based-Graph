package graph.drawings

import java.util.ArrayList

import fimme.graph.model.Grid

import fimme.graph.model.Vertex3D

trait TDrawing {

  def getVertices(): ArrayList[Vertex3D]

  def getEdges(): Grid

}

