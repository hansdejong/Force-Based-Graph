package graph.drawings

import graph.lib._
import scala.collection.mutable.ArrayBuffer
import graph.model.Grid
import graph.model.Vertex3D

//remove if not needed
import scala.collection.JavaConversions._

class RombischeDodecaeder extends TDrawing {

  var vertices: ArrayBuffer[Vertex3D] = new ArrayBuffer[Vertex3D]()
  var edges: Grid = null

  makeGraph_Dodecaeder()

  private def makeGraph_Dodecaeder(): Unit = {
    val numVertices: Int = 14
    edges = new Grid(numVertices)
    for (i <- 0.until(8)) {
      val v: Vertex3D = new Vertex3D("#DD0099")
      v.label_=(java.lang.Integer.toString(i))
      v.setXYZ(200 + Math.random() * 300,
               100 + Math.random() * 200,
               100 + Math.random() * 200)
      vertices.add(v)
    }
    for (i <- 8.until(14)) {
      var v: Vertex3D = null
      if (i == 8 || i == 13) v = new Vertex3D(Color.YELLOW)
      else if (i == 10 || i == 11) //        		v = new Vertex3D( Color.MAGENTA );
        v = new Vertex3D(Color.ORANGE)
      else if (i == 9 || i == 12) v = new Vertex3D(Color.CYAN)
      v.label_=(java.lang.Integer.toString(i))
      v.setXYZ(200 + Math.random() * 300,
               100 + Math.random() * 200,
               100 + Math.random() * 200)
      vertices.add(v)
    }
    edges.setConnected(0, 9, true)
    edges.setConnected(9, 1, true)
    edges.setConnected(1, 8, true)
    edges.setConnected(8, 0, true)
    edges.setConnected(0, 10, true)
    edges.setConnected(9, 4, true)
    edges.setConnected(9, 5, true)
    edges.setConnected(1, 11, true)
    edges.setConnected(8, 3, true)
    edges.setConnected(8, 2, true)
    edges.setConnected(2, 10, true)
    edges.setConnected(10, 4, true)
    edges.setConnected(3, 11, true)
    edges.setConnected(11, 5, true)
    edges.setConnected(2, 12, true)
    edges.setConnected(10, 6, true)
    edges.setConnected(4, 13, true)
    edges.setConnected(5, 13, true)
    edges.setConnected(11, 7, true)
    edges.setConnected(3, 12, true)
    edges.setConnected(6, 13, true)
    edges.setConnected(13, 7, true)
    edges.setConnected(7, 12, true)
    edges.setConnected(12, 6, true)
  }

}

