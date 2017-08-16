//package graph.drawings
//
//import java.awt.Color
//
//import java.util.ArrayList
//
//import graph.model.Grid
//
//import graph.model.Vertex3D
//
//
//class Snakering extends TDrawing {
//
//  var vertices: ArrayList[Vertex3D] = new ArrayList[Vertex3D]()
//
//  var edges: Grid = null
//
//  makeGraph_Snakering()
//
//  private def makeGraph_Snakering(): Unit = {
//    val numVertices: Int = 60
//    edges = new Grid(numVertices)
//    var v: Vertex3D = null
//    for (i <- 0.until(30)) {
//      v =
//        if (i % 3 == 0) new Vertex3D(Color.RED)
//        else if (i % 3 == 1) new Vertex3D(Color.WHITE)
//        else new Vertex3D(Color.BLUE)
//      v.label_=(java.lang.Integer.toString(i))
//      v.setXYZ(200 + Math.random() * 300,
//               100 + Math.random() * 200,
//               100 + Math.random() * 200)
//      vertices.add(v)
//    }
//    for (i <- 30.until(60)) {
//      v =
//        if (i % 3 == 0) new Vertex3D(Color.PINK)
//        else if (i % 3 == 1) new Vertex3D(Color.YELLOW)
//        else new Vertex3D(Color.CYAN)
//      v.label_=(java.lang.Integer.toString(i))
//      v.setXYZ(200 + Math.random() * 300,
//               100 + Math.random() * 200,
//               100 + Math.random() * 200)
//      vertices.add(v)
//    }
//    var a: Int = 0
//    var b: Int = 0
//    var c: Int = 0
//    for (i <- 0.until(30)) {
//      a = if ((i - 3 < 0)) i + 27 else i - 3
//      b = if ((i - 2 < 0)) i + 28 else i - 2
//      c = if ((i - 1 < 0)) i + 29 else i - 1
//      edges.setConnected(i, a, true)
//      edges.setConnected(i, b, true)
//      edges.setConnected(i, c, true)
//    }
//    for (i <- 30.until(60)) {
//      edges.setConnected(i, i - 30, true)
//    }
//  }
//
//}
//
