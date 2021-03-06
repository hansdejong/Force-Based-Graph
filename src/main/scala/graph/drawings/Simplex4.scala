package graph.drawings

import scala.collection.mutable.ArrayBuffer
import graph.model.Grid
import graph.model.Vertex3D


class Simplex4 extends TDrawing {

  var vertices: ArrayBuffer[Vertex3D] = new ArrayBuffer[Vertex3D]()
  var edges: Grid = null

  makeVertices()
  makeGraph_SimplexX(0, 20)

  private def makeVertices(): Unit = {
	  val numVertices: Int = 20
    edges = new Grid(numVertices)
    for (i <- 0 until numVertices) {
      val v: Vertex3D = new Vertex3D()
      v.label_=(java.lang.Integer.toString(i))
      v.setXYZ(200 + Math.random() * 300,
               100 + Math.random() * 200,
               100 + Math.random() * 200)
      vertices.append(v)
    }
  }
/*
  private def makeGraph_Simplex4(): Unit = {
    edges.setConnected(0, 1, true)
    edges.setConnected(0, 2, true)
    edges.setConnected(0, 3, true)
    edges.setConnected(0, 4, true)
    edges.setConnected(1, 2, true)
    edges.setConnected(1, 3, true)
    edges.setConnected(1, 4, true)
    edges.setConnected(2, 3, true)
    edges.setConnected(2, 4, true)
    edges.setConnected(3, 4, true)
  }

  private def makeGraph_Simplex5(): Unit = {
    val base: Int = 5
    edges.setConnected(base + 0, base + 1, true)
    edges.setConnected(base + 0, base + 2, true)
    edges.setConnected(base + 0, base + 3, true)
    edges.setConnected(base + 0, base + 4, true)
    edges.setConnected(base + 0, base + 5, true)
    edges.setConnected(base + 1, base + 2, true)
    edges.setConnected(base + 1, base + 3, true)
    edges.setConnected(base + 1, base + 4, true)
    edges.setConnected(base + 1, base + 5, true)
    edges.setConnected(base + 2, base + 3, true)
    edges.setConnected(base + 2, base + 4, true)
    edges.setConnected(base + 2, base + 5, true)
    edges.setConnected(base + 3, base + 4, true)
    edges.setConnected(base + 3, base + 5, true)
    edges.setConnected(base + 4, base + 5, true)
  }
*/
  private def makeGraph_SimplexX(base: Int, n: Int): Unit = {
 //   for (i <- 0 until n; j <- i + 1 until n + 1) {
    for (i <- 0 until n; j <- i until n) {
      edges.setConnected(base + i, base + j, true)
    }
  }

}

