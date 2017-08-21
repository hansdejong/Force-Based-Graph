package graph.drawings

import graph.lib._

import scala.collection.mutable.ArrayBuffer

import graph.model.Grid

import graph.model.Vertex3D

import scala.beans.{BeanProperty, BooleanBeanProperty}


class Mobius extends TDrawing {

  var vertices: ArrayBuffer[Vertex3D] = new ArrayBuffer[Vertex3D]()

  var edges: Grid = null

  makeGraph_Mobius()

  private def makeGraph_Mobius(): Unit = {
//4-voud+2
    val numVertices: Int = 22
    var v: Vertex3D = null
    edges = new Grid(numVertices)
    for (i <- 0 until numVertices) {
      v =
        if (i % 2 == 0) new Vertex3D(Color.RED) else new Vertex3D(Color.YELLOW)
      v.label_=(java.lang.Integer.toString(i))
      v.setXYZ(200 + Math.random() * 300,
               100 + Math.random() * 200,
               100 + Math.random() * 200)
      vertices.append(v)
    }
    for (i <- 0 until numVertices - 1) {
      edges.setConnected(i, i + 1, true)
    }
//Verbind 0 met 21 en 1 met 20
    edges.setConnected(0, numVertices - 1, true)
    edges.setConnected(1, numVertices - 2, true)
//en dat voor elke 4 hoger
    var i: Int = 0
    while (i < numVertices - 2) {
      edges.setConnected(i, i + 3, true)
      i = i + 4
    }
    var j: Int = 2 //Veranderd van i in j
    while (j < numVertices - 2) {
      edges.setConnected(j, j + 3, true)
      j = j + 4
    }
  }
//Verbind 0 met 3 en 2 met 5,
//Verbind 0 met 3 en 2 met 5,

}

