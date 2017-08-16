//package graph.drawings
//
//import java.awt.Color
//
//import java.util.ArrayList
////import graph.drawings.EDrawings
//
//import graph.model.Grid
//
//import graph.model.Vertex3D
//
//class Cube extends TDrawing {
//
//  var vertices: ArrayList[Vertex3D] = new ArrayList[Vertex3D]()
//
//  var edges: Grid = null
//
//  makeGraph_Cube()
//
//  private def makeGraph_Cube(): Unit = {
//    val numVertices: Int = 8
//    edges = new Grid(numVertices)
//    for (i <- 0 until numVertices) {
//      val v: Vertex3D = new Vertex3D(Color.RED)
//      v.label_=(java.lang.Integer.toString(i))
//      v.setXYZ(200 + Math.random() * 300,
//               100 + Math.random() * 200,
//               100 + Math.random() * 200)
//      vertices.add(v)
//    }
//    edges.setConnected(0, 1, true)
//    edges.setConnected(1, 2, true)
//    edges.setConnected(2, 3, true)
//    edges.setConnected(3, 0, true)
//    edges.setConnected(4, 5, true)
//    edges.setConnected(5, 6, true)
//    edges.setConnected(6, 7, true)
//    edges.setConnected(7, 4, true)
//    edges.setConnected(0, 4, true)
//    edges.setConnected(1, 5, true)
//    edges.setConnected(2, 6, true)
//    edges.setConnected(3, 7, true)
//  }
//
//}
//
