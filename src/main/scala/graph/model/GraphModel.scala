package graph.model

import scala.collection.mutable.ArrayBuffer

import graph.drawings.BuckyBall

import graph.drawings.Simplex4

import graph.drawings.Snake

import graph.drawings.Doughnut

import graph.drawings.EDrawings._

import graph.drawings.TDrawing

import graph.drawings.Mobius

import graph.drawings.Cube

import graph.drawings.Snakering

import graph.drawings.Tesseract

import graph.drawings.Sputnik

import graph.drawings.RombischeDodecaeder

import graph.errors.ProgrammingError

import graph.lib._


class GraphModel extends TGraphModel{

  var vertices: ArrayBuffer[Vertex3D] = new ArrayBuffer[Vertex3D]()

  var maxNumberOfEdges: Int = 0

  var edges: Grid = null

  private var foundEdgeVertex1: Int = 0

  private var foundEdgeVertex2: Int = 0

  def this(theNumberOfVertices: Int, theMaxNumberOfEdges: Int) = {
    this()
    maxNumberOfEdges = theMaxNumberOfEdges
    edges = new Grid(theNumberOfVertices)
    makeGraph(theNumberOfVertices)
  }

  def this(graphName: EDrawings) = {
    this()
    makeGraph(graphName)
  }

  def setVertexColor(index: Int, newColor: String): Unit = {
    (vertices(index)).color_=(newColor)
  }

  private def makeGraph(numVertices: Int): Unit = {
    for (j <- 0 until maxNumberOfEdges) {
// add some edges
      val a: Int = Math.floor(Math.random() * numVertices).toInt
      val b: Int = Math.floor(Math.random() * numVertices).toInt
      if (a == b || edges.isConnected(a, b)) //continue
//tweezijdig, en soms al true
        edges.setConnected(a, b, true)
    }
    for (i <- 0 until numVertices) {
      val v: Vertex3D = new Vertex3D()
      v.setXYZ(200 + Math.random() * 300,
               100 + Math.random() * 200,
               100 + Math.random() * 200)
      vertices.append(v)
    }
  }

//=====================================Vertex-code===================
  def findFirstVertex(point: Point2D): Int = {
    var currentVertex: Vertex3D = null
    for (i <- 0 until vertices.size) {
      currentVertex = vertices(i)
      if (VertexContains(currentVertex, point)) i
    }
    -1
  }

  def VertexContains(vertex: Vertex3D, point: Point2D): Boolean = {
    val x: Double = vertex.getX
    val y: Double = vertex.getY
    val r: Double = Vertex3D.radius
//  val shape: Shape = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r)
    val shape: Circle2D = new Circle2D(new Point2D(x, y), r)
    shape.contains(point)
  }

//=====================================Edge-code===================
//De originele (geconverteerde) code
//  def findEdge(point: Point2D): Boolean = {
//    for (i <- 0 until vertices.size; j <- 0 until vertices.size) {
//      if (!edges.isConnected(i, j)) //continue
//        if (edgeContains(point, i, j)) {
//          foundEdgeVertex1 = i
//          foundEdgeVertex2 = j
//          true
//        }
//    }
//    false
//  }
  def findEdge(point: Point2D): Boolean = {
    for (i <- 0 until vertices.size; j <- 0 until vertices.size) {
      if (  edges.isConnected(i, j) && edgeContains(point, i, j) ) {
          foundEdgeVertex1 = i
          foundEdgeVertex2 = j
          true
        }
    }
    false
  }

  def removeEdge(vertex1: Int, vertex2: Int): Unit = {
    //val edges: Grid = edges
    edges.setConnected(vertex1, vertex2, false)
  }

  def getLastFoundEdgeVertex1(): Int = foundEdgeVertex1

  def getLastFoundEdgeVertex2(): Int = foundEdgeVertex2

  private def edgeContains(point: Point2D, v1: Int, v2: Int): Boolean = {
    val d: Double = 2
    val vtx1: Vertex3D = vertices(v1)
    val vtx2: Vertex3D = vertices(v2)
    val x1: Double = vtx1.getX
    val y1: Double = vtx1.getY
    val x2: Double = vtx2.getX
    val y2: Double = vtx2.getY
   //HERSTELLEN  FBGLib.onLine(point.x, point.y, x1, y1, x2, y2, d)
    false
  }

  private def makeGraph(theGraphName: EDrawings): Unit = {
    theGraphName match {
      case RANDOM => makeGraph_Random()
      case CUBE => makeGraph_Cube()
      case BUCKYBALL => makeGraph_Buckyball()
      case MOBIUS => makeGraph_Mobius()
      case DOUGHNUT => makeGraph_Doughnut()
      case TESSERACT => makeGraph_Tesseract()
      case SNAKE => makeGraph_Snake()
      case SNAKERING => makeGraph_Snakering()
      case SIMPLEX4 => makeGraph_Simplex4()
      case SPUTNIK => makeGraph_Sputnik()
      case DODECAEDER => makeGraph_Dodecaeder()
      case _ =>
        throw new ProgrammingError(
          "Unknown graphname inGraphModel.makeGraph()")

    }
  }
//		makeGraph_Doughnut();
//		makeGraph_Tesseract();
//		makeGraph_Snake();
//		makeGraph_Snakering();
//		makeGraph_Simplex4();
//		makeGraph_Doughnut();
//		makeGraph_Tesseract();
//		makeGraph_Snake();
//		makeGraph_Snakering();
//		makeGraph_Simplex4();

  private def makeGraph_Random(): Unit = {
//Voorlopig zelfde aantallen
    val numEdges: Int = 20
    val numVertices: Int = 15
    maxNumberOfEdges = numEdges
    edges = new Grid(numVertices)
    makeGraph(numVertices)
  }

  private def makeGraph_Cube(): Unit = {
    val cube: TDrawing = new Cube()
    vertices = cube.vertices
    edges = cube.edges
  }

  private def makeGraph_Buckyball(): Unit = {
    val bucky: TDrawing = new BuckyBall()
    vertices = bucky.vertices
    edges = bucky.edges
  }

  private def makeGraph_Mobius(): Unit = {
    val mobius: TDrawing = new Mobius()
    vertices = mobius.vertices
    edges = mobius.edges
  }

  private def makeGraph_Doughnut(): Unit = {
    val donut: TDrawing = new Doughnut(8, 8)
    vertices = donut.vertices
    edges = donut.edges
  }

  private def makeGraph_Tesseract(): Unit = {
    val tess: TDrawing = new Tesseract()
    vertices = tess.vertices
    edges = tess.edges
  }

  private def makeGraph_Snake(): Unit = {
    val snake: TDrawing = new Snake()
    vertices = snake.vertices
    edges = snake.edges
  }

  private def makeGraph_Snakering(): Unit = {
    val snakering: TDrawing = new Snakering()
    vertices = snakering.vertices
    edges = snakering.edges
  }

  private def makeGraph_Simplex4(): Unit = {
    val simplex4: TDrawing = new Simplex4()
    vertices = simplex4.vertices
    edges = simplex4.edges
  }

  private def makeGraph_Sputnik(): Unit = {
    val sputnik: TDrawing = new Sputnik()
    vertices = sputnik.vertices
    edges = sputnik.edges
  }

  private def makeGraph_Dodecaeder(): Unit = {
    val dodecaeder: TDrawing = new RombischeDodecaeder()
    vertices = dodecaeder.vertices
    edges = dodecaeder.edges
  }

}

