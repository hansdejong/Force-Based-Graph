package graph.drawings

import scala.collection.mutable.ArrayBuffer
import graph.model.Grid
import graph.model.Vertex3D

class Stick extends TDrawing {

  var vertices: ArrayBuffer[Vertex3D] = new ArrayBuffer[Vertex3D]()
  var edges: Grid = null

  makeGraph_Stick()

  private def makeGraph_Stick(): Unit = {
    val numVertices: Int = 3
    edges = new Grid(numVertices)
    for (i <- 0 until numVertices) {
      val v: Vertex3D = new Vertex3D() //random color
      v.label_=(java.lang.Integer.toString(i))
      v.setXYZ(200 + Math.random() * 300,
               100 + Math.random() * 200,
               100 + Math.random() * 200)
      vertices.append(v)
    }
    edges.setConnected(0, 1, true)
    edges.setConnected(1, 2, true)
  }

}

