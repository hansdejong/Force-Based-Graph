//package graph.model
//
//import java.io.Serializable
//
//import fimme.graph.lib.Lib
//
//class Grid {
//
//  var edgeArray: Array[Array[Edge]] = null
//  var ribSize: Int = 0
//  var edgeCount: Int = 0
//
//  def this(theEdgeCount: Int) = {
//    this()
//    ribSize = edgeCount = theEdgeCount
//    edgeArray = Array.ofDim[Edge](ribSize, ribSize)
//    for (i <- 0 until ribSize; j <- 0 until ribSize) {
//      edgeArray(i)(j) = new Edge()
//    }
//  }
//
//  def isConnected(x: Int, y: Int): Boolean = edgeArray(x)(y).isConnected
//
//  def setConnected(x: Int, y: Int, bool: Boolean): Unit = {
//    if (x < 0 || y < 0)
//      throw new IndexOutOfBoundsException("Grid.set (negative x or y)")
//    if (x < edgeCount && y < edgeCount) {
////Binnen alle grenzen
//      edgeArray(x)(y).setConnected(bool)
//      edgeArray(y)(x).setConnected(bool)
//    } else //========================================
//    if (x <= edgeCount && y <= edgeCount) {
////goed, al dan niet met resizen
//      { edgeCount += 1; edgeCount - 1 }
//      if (x == ribSize || y == ribSize) {
//        resize()
//      }
//      setConnected(x, y, bool)
//    } else
//      throw new IndexOutOfBoundsException(
//        "Grid.set( step being bigger then one )")
//  }
//
//  private def resize(): Unit = {
////NIET WEG VOOR ARRAYCOPY GOED IS GETEST
//    val temp: Array[Array[Edge]] = edgeArray
//    val oldRibSize: Int = ribSize
//    ribSize *= 2
//    edgeArray = Array.ofDim[Edge](ribSize, ribSize)
//    for (i <- 0 until ribSize; j <- 0 until ribSize) {
//      edgeArray(i)(j) = new Edge()
//    }
//    for (i <- 0 until oldRibSize; j <- 0 until oldRibSize) {
////Gaat dit goed met null?
//      edgeArray(i)(j) = temp(i)(j)
//    }
//    Lib.melding("Resized!", "Grid.resize()")
//  }
//
//}
//
////Grid is een vierkant array van Edges
////Grid houdt rekening met symmetrische uitvoering: (a,b) is (b,a)
////Voorlopig is een edge gewoon null of niet, later wordt de lengte van belang
//
