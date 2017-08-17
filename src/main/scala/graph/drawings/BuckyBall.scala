package graph.drawings

import java.awt.Color

import scala.collection.mutable.ArrayBuffer

import graph.model.Grid

import graph.model.Vertex3D


class BuckyBall extends TDrawing {

  var vertices: ArrayBuffer[Vertex3D] = new ArrayBuffer[Vertex3D]()

  var edges: Grid = null

  makeGraph_BuckyBall()

  private def makeGraph_BuckyBall(): Unit = {
    val numVertices: Int = 60
    edges = new Grid(numVertices)
    for (i <- 0.until(5)) {
      val v: Vertex3D = new Vertex3D(Color.YELLOW)
      v.label_=(java.lang.Integer.toString(i))
      v.setXYZ(200 + Math.random() * 300,
               100 + Math.random() * 200,
               100 + Math.random() * 200)
      vertices.append(v)
    }
    for (i <- 5.until(10)) {
      val v: Vertex3D = new Vertex3D(Color.BLUE)
      v.label_=(java.lang.Integer.toString(i))
      v.setXYZ(200 + Math.random() * 300,
               100 + Math.random() * 200,
               100 + Math.random() * 200)
      vertices.append(v)
    }
    for (i <- 10.until(15)) {
      val v: Vertex3D = new Vertex3D(Color.CYAN)
      v.label_=(java.lang.Integer.toString(i))
      v.setXYZ(200 + Math.random() * 300,
               100 + Math.random() * 200,
               100 + Math.random() * 200)
      vertices.append(v)
    }
    for (i <- 15.until(20)) {
      val v: Vertex3D = new Vertex3D(Color.GREEN)
      v.label_=(java.lang.Integer.toString(i))
      v.setXYZ(200 + Math.random() * 300,
               100 + Math.random() * 200,
               100 + Math.random() * 200)
      vertices.append(v)
    }
    for (i <- 20.until(25)) {
      val v: Vertex3D = new Vertex3D(Color.MAGENTA)
      v.label_=(java.lang.Integer.toString(i))
      v.setXYZ(200 + Math.random() * 300,
               100 + Math.random() * 200,
               100 + Math.random() * 200)
      vertices.append(v)
    }
    for (i <- 25.until(30)) {
      val v: Vertex3D = new Vertex3D(new Color(0x80000000))
      v.label_=(java.lang.Integer.toString(i))
      v.setXYZ(200 + Math.random() * 300,
               100 + Math.random() * 200,
               100 + Math.random() * 200)
      vertices.append(v)
    }
    for (i <- 30.until(35)) {
      val v: Vertex3D = new Vertex3D(new Color(0x8395ee))
      v.label_=(java.lang.Integer.toString(i))
      v.setXYZ(200 + Math.random() * 300,
               100 + Math.random() * 200,
               100 + Math.random() * 200)
      vertices.append(v)
    }
    for (i <- 35.until(40)) {
      val v: Vertex3D = new Vertex3D(Color.PINK)
      v.label_=(java.lang.Integer.toString(i))
      v.setXYZ(200 + Math.random() * 300,
               100 + Math.random() * 200,
               100 + Math.random() * 200)
      vertices.append(v)
    }
    for (i <- 40.until(45)) {
      val v: Vertex3D = new Vertex3D(Color.BLACK)
      v.label_=(java.lang.Integer.toString(i))
      v.setXYZ(200 + Math.random() * 300,
               100 + Math.random() * 200,
               100 + Math.random() * 200)
      vertices.append(v)
    }
    for (i <- 45.until(50)) {
      val v: Vertex3D = new Vertex3D(Color.GRAY)
      v.label_=(java.lang.Integer.toString(i))
      v.setXYZ(200 + Math.random() * 300,
               100 + Math.random() * 200,
               100 + Math.random() * 200)
      vertices.append(v)
    }
    for (i <- 50.until(55)) {
      val v: Vertex3D = new Vertex3D(Color.WHITE)
      v.label_=(java.lang.Integer.toString(i))
      v.setXYZ(200 + Math.random() * 300,
               100 + Math.random() * 200,
               100 + Math.random() * 200)
      vertices.append(v)
    }
    for (i <- 55.until(60)) {
      val v: Vertex3D = new Vertex3D(Color.RED)
      v.label_=(java.lang.Integer.toString(i))
      v.setXYZ(200 + Math.random() * 300,
               100 + Math.random() * 200,
               100 + Math.random() * 200)
      vertices.append(v)
    }
    edges.setConnected(0, 1, true)
    edges.setConnected(1, 2, true)
    edges.setConnected(2, 3, true)
    edges.setConnected(3, 4, true)
    edges.setConnected(4, 0, true)
    edges.setConnected(5, 6, true)
    edges.setConnected(6, 7, true)
    edges.setConnected(7, 8, true)
    edges.setConnected(8, 9, true)
    edges.setConnected(9, 5, true)
    edges.setConnected(10, 11, true)
    edges.setConnected(11, 12, true)
    edges.setConnected(12, 13, true)
    edges.setConnected(13, 14, true)
    edges.setConnected(14, 10, true)
    edges.setConnected(15, 16, true)
    edges.setConnected(16, 17, true)
    edges.setConnected(17, 18, true)
    edges.setConnected(18, 19, true)
    edges.setConnected(19, 15, true)
    edges.setConnected(20, 21, true)
    edges.setConnected(21, 22, true)
    edges.setConnected(22, 23, true)
    edges.setConnected(23, 24, true)
    edges.setConnected(24, 20, true)
    edges.setConnected(25, 26, true)
    edges.setConnected(26, 27, true)
    edges.setConnected(27, 28, true)
    edges.setConnected(28, 29, true)
    edges.setConnected(29, 25, true)
    edges.setConnected(30, 31, true)
    edges.setConnected(31, 32, true)
    edges.setConnected(32, 33, true)
    edges.setConnected(33, 34, true)
    edges.setConnected(34, 30, true)
    edges.setConnected(35, 36, true)
    edges.setConnected(36, 37, true)
    edges.setConnected(37, 38, true)
    edges.setConnected(38, 39, true)
    edges.setConnected(39, 35, true)
    edges.setConnected(40, 41, true)
    edges.setConnected(41, 42, true)
    edges.setConnected(42, 43, true)
    edges.setConnected(43, 44, true)
    edges.setConnected(44, 40, true)
    edges.setConnected(45, 46, true)
    edges.setConnected(46, 47, true)
    edges.setConnected(47, 48, true)
    edges.setConnected(48, 49, true)
    edges.setConnected(49, 45, true)
    edges.setConnected(50, 51, true)
    edges.setConnected(51, 52, true)
    edges.setConnected(52, 53, true)
    edges.setConnected(53, 54, true)
    edges.setConnected(54, 50, true)
    edges.setConnected(55, 56, true)
    edges.setConnected(56, 57, true)
    edges.setConnected(57, 58, true)
    edges.setConnected(58, 59, true)
    edges.setConnected(59, 55, true)
//===========================================================    	
    edges.setConnected(0, 46, true)
    edges.setConnected(1, 5, true)
    edges.setConnected(2, 14, true)
    edges.setConnected(3, 50, true)
    edges.setConnected(4, 42, true)

    edges.setConnected(5, 9, true)

    edges.setConnected(6, 10, true)
    edges.setConnected(7, 19, true)
    edges.setConnected(8, 55, true)
    edges.setConnected(9, 47, true)
    edges.setConnected(11, 15, true)
    edges.setConnected(12, 24, true)
    edges.setConnected(13, 51, true)
    edges.setConnected(16, 20, true)
    edges.setConnected(17, 29, true)
    edges.setConnected(18, 56, true)
    edges.setConnected(21, 25, true)
    edges.setConnected(22, 34, true)
    edges.setConnected(23, 52, true)
    edges.setConnected(26, 30, true)
    edges.setConnected(27, 39, true)
    edges.setConnected(28, 57, true)
//===========================================================    	
    edges.setConnected(31, 35, true)
    edges.setConnected(32, 44, true)
    edges.setConnected(33, 53, true)
    edges.setConnected(36, 40, true)
    edges.setConnected(37, 49, true)
    edges.setConnected(38, 58, true)
    edges.setConnected(41, 45, true)
    edges.setConnected(43, 54, true)

    edges.setConnected(46, 0, true)

    edges.setConnected(47, 9, true)
    edges.setConnected(48, 59, true)
  }

}

