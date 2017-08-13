//package graph.model
//
//import java.awt.Color
//
//import java.awt.Shape
//
//import java.awt.geom.Ellipse2D
//
//import java.awt.geom.Point2D
//
//import java.io.Serializable
//
//import java.util.ArrayList
//
//import drawings.BuckyBall
//
//import drawings.Simplex4
//
//import drawings.Snake
//
//import drawings.Doughnut
//
//import drawings.EDrawings
//
//import drawings.IDrawing
//
//import drawings.Mobius
//
//import drawings.Cube
//
//import drawings.Snakering
//
//import drawings.Tesseract
//
//import drawings.Sputnik
//
//import drawings.RombischeDodecaeder
//
//import fimme.graph.errors.ProgrammingError
//
//import fimme.graph.lib.Lib
//
//
//class GraphModel {
//
//  var vertices: ArrayList[Vertex3D] = new ArrayList[Vertex3D]()
//
//  var maxNumberOfEdges: Int = 0
//
//  var edges: Grid = null
//
//  private var foundEdgeVertex1: Int = 0
//
//  private var foundEdgeVertex2: Int = 0
//
//  def this(theNumberOfVertices: Int, theMaxNumberOfEdges: Int) = {
//    this()
//    maxNumberOfEdges = theMaxNumberOfEdges
//    edges = new Grid(theNumberOfVertices)
//    makeGraph(theNumberOfVertices)
//  }
//
//  def this(graphName: EDrawings) = {
//    this()
//    makeGraph(graphName)
//  }
//
//  def setVertexColor(index: Int, newColor: Color): Unit = {
//    (vertices.get(index)).setColor(newColor)
//  }
//
//  private def makeGraph(numVertices: Int): Unit = {
//    for (j <- 0 until maxNumberOfEdges) {
//// add some edges
//      val a: Int = Math.floor(Math.random() * numVertices).toInt
//      val b: Int = Math.floor(Math.random() * numVertices).toInt
//      if (a == b || edges.isConnected(a, b)) //continue
////tweezijdig, en soms al true
//        edges.setConnected(a, b, true)
//    }
//    for (i <- 0 until numVertices) {
//      val v: Vertex3D = new Vertex3D()
//      v.setXYZ(200 + Math.random() * 300,
//               100 + Math.random() * 200,
//               100 + Math.random() * 200)
//      vertices.add(v)
//    }
//  }
//
////=====================================Vertex-code===================
//  def findFirstVertex(point: Point2D.Double): Int = {
//    var currentVertex: Vertex3D = null
//    for (i <- 0 until vertices.size) {
//      currentVertex = vertices.get(i)
//      if (VertexContains(currentVertex, point)) i
//    }
//    -1
//  }
//
//  def VertexContains(vertex: Vertex3D, point: Point2D.Double): Boolean = {
//    val x: Double = vertex.getX
//    val y: Double = vertex.getY
//    val r: Double = Vertex3D.getRadius
//    val shape: Shape = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r)
//    shape.contains(point)
//  }
//
////=====================================Edge-code===================
//  def findEdge(point: Point2D.Double): Boolean = {
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
//
//  def removeEdge(vertex1: Int, vertex2: Int): Unit = {
//    val edges: Grid = getEdges
//    edges.setConnected(vertex1, vertex2, false)
//  }
//
//  def getLastFoundEdgeVertex1(): Int = foundEdgeVertex1
//
//  def getLastFoundEdgeVertex2(): Int = foundEdgeVertex2
//
//  private def edgeContains(point: Point2D, v1: Int, v2: Int): Boolean = {
//    val d: Double = 2
//    val vtx1: Vertex3D = vertices.get(v1)
//    val vtx2: Vertex3D = vertices.get(v2)
//    val x1: Double = vtx1.getX
//    val y1: Double = vtx1.getY
//    val x2: Double = vtx2.getX
//    val y2: Double = vtx2.getY
//    Lib.onLine(point.getX, point.getY, x1, y1, x2, y2, d)
//  }
//
//  private def makeGraph(theGraphName: EDrawings): Unit = {
//    theGraphName match {
//      case RANDOM => makeGraph_Random()
//      case CUBE => makeGraph_Cube()
//      case BUCKYBALL => makeGraph_Buckyball()
//      case MOBIUS => makeGraph_Mobius()
//      case DOUGHNUT => makeGraph_Doughnut()
//      case TESSERACT => makeGraph_Tesseract()
//      case SNAKE => makeGraph_Snake()
//      case SNAKERING => makeGraph_Snakering()
//      case SIMPLEX4 => makeGraph_Simplex4()
//      case SPUTNIK => makeGraph_Sputnik()
//      case DODECAEDER => makeGraph_Dodecaeder()
//      case _ =>
//        throw new ProgrammingError(
//          "Unknown graphname inGraphModel.makeGraph()")
//
//    }
//  }
////		makeGraph_Doughnut();
////		makeGraph_Tesseract();
////		makeGraph_Snake();
////		makeGraph_Snakering();
////		makeGraph_Simplex4();
////		makeGraph_Doughnut();
////		makeGraph_Tesseract();
////		makeGraph_Snake();
////		makeGraph_Snakering();
////		makeGraph_Simplex4();
//
//  private def makeGraph_Random(): Unit = {
////Voorlopig zelfde aantallen
//    val numEdges: Int = 20
//    val numVertices: Int = 15
//    maxNumberOfEdges = numEdges
//    edges = new Grid(numVertices)
//    makeGraph(numVertices)
//  }
//
//  private def makeGraph_Cube(): Unit = {
//    val cube: IDrawing = new Cube()
//    vertices = cube.getVertices
//    edges = cube.getEdges
//  }
//
//  private def makeGraph_Buckyball(): Unit = {
//    val bucky: IDrawing = new BuckyBall()
//    vertices = bucky.getVertices
//    edges = bucky.getEdges
//  }
//
//  private def makeGraph_Mobius(): Unit = {
//    val mobius: IDrawing = new Mobius()
//    vertices = mobius.getVertices
//    edges = mobius.getEdges
//  }
//
//  private def makeGraph_Doughnut(): Unit = {
//    val donut: IDrawing = new Doughnut(8, 8)
//    vertices = donut.getVertices
//    edges = donut.getEdges
//  }
//
//  private def makeGraph_Tesseract(): Unit = {
//    val tess: IDrawing = new Tesseract()
//    vertices = tess.getVertices
//    edges = tess.getEdges
//  }
//
//  private def makeGraph_Snake(): Unit = {
//    val snake: IDrawing = new Snake()
//    vertices = snake.getVertices
//    edges = snake.getEdges
//  }
//
//  private def makeGraph_Snakering(): Unit = {
//    val snakering: IDrawing = new Snakering()
//    vertices = snakering.getVertices
//    edges = snakering.getEdges
//  }
//
//  private def makeGraph_Simplex4(): Unit = {
//    val simplex4: IDrawing = new Simplex4()
//    vertices = simplex4.getVertices
//    edges = simplex4.getEdges
//  }
//
//  private def makeGraph_Sputnik(): Unit = {
//    val sputnik: IDrawing = new Sputnik()
//    vertices = sputnik.getVertices
//    edges = sputnik.getEdges
//  }
//
//  private def makeGraph_Dodecaeder(): Unit = {
//    val dodecaeder: IDrawing = new RombischeDodecaeder()
//    vertices = dodecaeder.getVertices
//    edges = dodecaeder.getEdges
//  }
//
//}
//
