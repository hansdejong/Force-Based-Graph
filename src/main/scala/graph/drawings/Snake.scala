package graph.drawings

import graph.lib._

import scala.collection.mutable.ArrayBuffer

import graph.model.Grid

import graph.model.Vertex3D


class Snake extends TDrawing {

  var vertices: ArrayBuffer[Vertex3D] = new ArrayBuffer[Vertex3D]()

  var edges: Grid = null

  makeGraph_Snake()

  private def makeGraph_Snake(): Unit = {
    val numVertices: Int = 40
    edges = new Grid(numVertices)
    var v: Vertex3D = null
    for (i <- 0.until(20)) {
      v =
        if (i % 3 == 0) new Vertex3D(Color.RED)
        else if (i % 3 == 1) new Vertex3D(Color.WHITE)
        else new Vertex3D(Color.BLUE)
      v.label_=(java.lang.Integer.toString(i))
      v.setXYZ(200 + Math.random() * 300,
               100 + Math.random() * 200,
               100 + Math.random() * 200)
      vertices.append(v)
    }
    for (i <- 20.until(40)) {
      v =
        if (i % 3 == 0) new Vertex3D(Color.YELLOW)
        else if (i % 3 == 1) new Vertex3D(Color.CYAN)
        else new Vertex3D(Color.PINK)
      v.label_=(java.lang.Integer.toString(i))
      v.setXYZ(200 + Math.random() * 300,
               100 + Math.random() * 200,
               100 + Math.random() * 200)
      vertices.append(v)
    }
    edges.setConnected(0, 1, true)
    edges.setConnected(1, 2, true)
    edges.setConnected(2, 0, true)
    edges.setConnected(3, 0, true)
    edges.setConnected(3, 1, true)
    edges.setConnected(3, 2, true)
    edges.setConnected(4, 1, true)
    edges.setConnected(4, 2, true)
    edges.setConnected(4, 3, true)
    edges.setConnected(5, 2, true)
    edges.setConnected(5, 3, true)
    edges.setConnected(5, 4, true)
    edges.setConnected(6, 3, true)
    edges.setConnected(6, 4, true)
    edges.setConnected(6, 5, true)
    edges.setConnected(7, 4, true)
    edges.setConnected(7, 5, true)
    edges.setConnected(7, 6, true)
    edges.setConnected(8, 5, true)
    edges.setConnected(8, 6, true)
    edges.setConnected(8, 7, true)
    edges.setConnected(9, 6, true)
    edges.setConnected(9, 7, true)
    edges.setConnected(9, 8, true)
    edges.setConnected(10, 7, true)
    edges.setConnected(10, 8, true)
    edges.setConnected(10, 9, true)
    edges.setConnected(11, 8, true)
    edges.setConnected(11, 9, true)
    edges.setConnected(11, 10, true)
    edges.setConnected(12, 9, true)
    edges.setConnected(12, 10, true)
    edges.setConnected(12, 11, true)
    edges.setConnected(13, 10, true)
    edges.setConnected(13, 11, true)
    edges.setConnected(13, 12, true)
    edges.setConnected(14, 11, true)
    edges.setConnected(14, 12, true)
    edges.setConnected(14, 13, true)
    edges.setConnected(15, 12, true)
    edges.setConnected(15, 13, true)
    edges.setConnected(15, 14, true)
    edges.setConnected(16, 13, true)
    edges.setConnected(16, 14, true)
    edges.setConnected(16, 15, true)
    edges.setConnected(17, 14, true)
    edges.setConnected(17, 15, true)
    edges.setConnected(17, 16, true)
    edges.setConnected(18, 15, true)
    edges.setConnected(18, 16, true)
    edges.setConnected(18, 17, true)
    edges.setConnected(19, 16, true)
    edges.setConnected(19, 17, true)
    edges.setConnected(19, 18, true)
//===
    edges.setConnected(20, 0, true)
    edges.setConnected(21, 1, true)
    edges.setConnected(22, 2, true)
    edges.setConnected(23, 3, true)
    edges.setConnected(24, 4, true)
    edges.setConnected(25, 5, true)
    edges.setConnected(26, 6, true)
    edges.setConnected(27, 7, true)
    edges.setConnected(28, 8, true)
    edges.setConnected(29, 9, true)
    edges.setConnected(30, 10, true)
    edges.setConnected(31, 11, true)
    edges.setConnected(32, 12, true)
    edges.setConnected(33, 13, true)
    edges.setConnected(34, 14, true)
    edges.setConnected(35, 15, true)
    edges.setConnected(36, 16, true)
    edges.setConnected(37, 17, true)
    edges.setConnected(38, 18, true)
    edges.setConnected(39, 19, true)
  }

}

