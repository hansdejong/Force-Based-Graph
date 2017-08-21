package graph.drawings

import graph.lib._

import scala.collection.mutable.ArrayBuffer

import graph.model.Grid

import graph.model.Vertex3D


class Sputnik extends TDrawing {

  var vertices: ArrayBuffer[Vertex3D] = new ArrayBuffer[Vertex3D]()

  var edges: Grid = null

  makeGraph_Sputnik()

  private def makeGraph_Sputnik(): Unit = {
    val numVertices: Int = 25
    val numVerticesPerCube: Int = 8
    edges = new Grid(numVertices)
    for (i <- 0 until numVerticesPerCube) {
      val v: Vertex3D = new Vertex3D("#FF0099")
      v.label_=(java.lang.Integer.toString(i))
      v.setXYZ(200 + Math.random() * 300,
               100 + Math.random() * 200,
               100 + Math.random() * 200)
      vertices.append(v)
    }
    edges.setConnected(0, 1, true)
    edges.setConnected(1, 2, true)
    edges.setConnected(2, 3, true)
    edges.setConnected(3, 0, true)
    edges.setConnected(4, 5, true)
    edges.setConnected(5, 6, true)
    edges.setConnected(6, 7, true)
    edges.setConnected(7, 4, true)
    edges.setConnected(0, 4, true)
    edges.setConnected(1, 5, true)
    edges.setConnected(2, 6, true)
    edges.setConnected(3, 7, true)
    for (i <- 0 until numVerticesPerCube) {
      val v: Vertex3D = new Vertex3D("#3333FF")
      v.label_=(java.lang.Integer.toString(i + 8))
      v.setXYZ(200 + Math.random() * 300,
               100 + Math.random() * 200,
               100 + Math.random() * 200)
      vertices.append(v)
    }
    edges.setConnected(0 + 8, 1 + 8, true)
    edges.setConnected(1 + 8, 2 + 8, true)
    edges.setConnected(2 + 8, 3 + 8, true)
    edges.setConnected(3 + 8, 0 + 8, true)
    edges.setConnected(4 + 8, 5 + 8, true)
    edges.setConnected(5 + 8, 6 + 8, true)
    edges.setConnected(6 + 8, 7 + 8, true)
    edges.setConnected(7 + 8, 4 + 8, true)
    edges.setConnected(0 + 8, 4 + 8, true)
    edges.setConnected(1 + 8, 5 + 8, true)
    edges.setConnected(2 + 8, 6 + 8, true)
    edges.setConnected(3 + 8, 7 + 8, true)
    for (i <- 0.until(8)) {
      edges.setConnected(i, i + 8, true)
    }
    for (i <- 0 until numVerticesPerCube) {
      val v: Vertex3D = new Vertex3D("#ccffff")
      v.label_=(java.lang.Integer.toString(i + 16))
      v.setXYZ(200 + Math.random() * 300,
               100 + Math.random() * 200,
               100 + Math.random() * 200)
      vertices.append(v)
    }
    for (i <- 0 until numVerticesPerCube) {
      edges.setConnected(i, i + 16, true)
    }
//Maak een gele en
    val v: Vertex3D = new Vertex3D(Color.YELLOW)
    v.setXYZ(200 + Math.random() * 300,
             100 + Math.random() * 200,
             100 + Math.random() * 200)
    vertices.append(v)
    for (i <- 8.until(16)) {
      edges.setConnected(i, 24, true)
    }
  }

}

