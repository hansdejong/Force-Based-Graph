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
//class Doughnut extends TDrawing {
//
//  var vertices: ArrayList[Vertex3D] = new ArrayList[Vertex3D]()
//
//  var edges: Grid = null
//
////Liefst even
//  private var numRows: Int = 8
//
////Liefst even
//  private var numColumns: Int = 8
//
//  makeGraph_Doughnut()
//
//  def this(rows: Int, columns: Int) = {
//    this()
//    numRows = rows
//    numColumns = columns
//    makeGraph_Doughnut()
//  }
//
//  private def makeGraph_Doughnut(): Unit = {
//    val numVertices: Int = numRows * numColumns
//    var v: Vertex3D = null
//    edges = new Grid(numVertices)
//    for (i <- 0 until numRows; j <- 0 until numColumns) {
//      v =
//        if (i % 2 == 0) new Vertex3D(Color.ORANGE)
//        else new Vertex3D(Color.BLUE)
//      v.label_=(java.lang.Integer.toString(i))
//      v.setXYZ(200 + Math.random() * 300,
//               100 + Math.random() * 200,
//               100 + Math.random() * 200)
//      vertices.add(v)
//    }
//    for (i <- 0 until numVertices - numColumns) {
//      edges.setConnected(i, i + numColumns, true)
//    }
//    for (i <- 0 until numVertices if i % numColumns != 0) {
//      edges.setConnected(i - 1, i, true)
//    }
//    for (i <- 0 until numRows) {
//      edges.setConnected(i * numColumns, (i + 1) * numColumns - 1, true)
//    }
//    for (i <- 0 until numColumns) {
//      edges.setConnected(i, numVertices - numColumns + i, true)
//    }
//  }
//
//}
//
