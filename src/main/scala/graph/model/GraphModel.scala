package graph.model

import scala.collection.mutable.ArrayBuffer
import graph.drawings._
import graph.drawings.EDrawings._
import graph.lib._
import graph.global._


class GraphModel extends TGraphModel{

  var vertices: ArrayBuffer[Vertex3D] = new ArrayBuffer[Vertex3D]()
  var maxNumberOfEdges: Int = 10
  var edges: Grid = null

  def this(graphName: EDrawings) = {
    this()
    makeGraph(graphName)
  }

  def setVertexColor(index: Int, newColor: String): Unit = {
    (vertices(index)).color_=(newColor)
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
    val shape: Circle2D = new Circle2D(new Point2D(x, y), r)
    shape.contains(point)
  }


  private def makeGraph(theGraphName: EDrawings): Unit = {
    theGraphName match {
      case BUCKYBALL => makeGraph_Buckyball()
      case CUBE => makeGraph_Cube()
      case DODECAEDER => makeGraph_Romb_Dodecaeder()
      case DOUGHNUT => makeGraph_Doughnut()
      case MOBIUS => makeGraph_Mobius()
      case RANDOM => makeGraph_Random()
      case SNAKE => makeGraph_Snake()
      case SNAKERING => makeGraph_Snakering()
//    case SIMPLEX4 => makeGraph_Simplex4()
      case SPUTNIK => makeGraph_Sputnik()
      case STICK => makeGraph_Stick()
      case TESSERACT => makeGraph_Tesseract()
      case _ =>
    }
  }

  private def makeGraph_Buckyball(): Unit = {
    val bucky: TDrawing = new BuckyBall()
    vertices = bucky.vertices
    edges = bucky.edges
  }

  private def makeGraph_Cube(): Unit = {
    val cube: TDrawing = new Cube()
    vertices = cube.vertices
    edges = cube.edges
  }

  private def makeGraph_Romb_Dodecaeder(): Unit = {
    val dodecaeder: TDrawing = new RombischeDodecaeder()
    vertices = dodecaeder.vertices
    edges = dodecaeder.edges
  }

  private def makeGraph_Doughnut(): Unit = {
    //val doughnut: TDrawing = new Doughnut(8, 8)
    val doughnut: TDrawing = new Doughnut()
    vertices = doughnut.vertices
    edges = doughnut.edges
  }

  private def makeGraph_Mobius(): Unit = {
    val mobius: TDrawing = new Mobius()
    vertices = mobius.vertices
    edges = mobius.edges
  }

  private def makeGraph_Random(): Unit = {
    val numVertices = Global.gNodes
    maxNumberOfEdges = Global.gEdges
    edges = new Grid(numVertices)

    for (j <- 0 until maxNumberOfEdges) {
// add some edges
      val a: Int = Math.floor(Math.random() * numVertices).toInt
      val b: Int = Math.floor(Math.random() * numVertices).toInt
      if (!(a == b || edges.isConnected(a, b))) //continue
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
    Global.appendMsg("GraphModel.makeGraph RandomGraph:\n" + edges)
  }

  private def makeGraph_Simplex4(): Unit = {
    val simplex4: TDrawing = new Simplex4()
    vertices = simplex4.vertices
    edges = simplex4.edges
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

  private def makeGraph_Sputnik(): Unit = {
    val sputnik: TDrawing = new Sputnik()
    vertices = sputnik.vertices
    edges = sputnik.edges
  }

  private def makeGraph_Stick(): Unit = {
    val stick: TDrawing = new Stick()
    vertices = stick.vertices
    edges = stick.edges
  }

  private def makeGraph_Tesseract(): Unit = {
    val tess: TDrawing = new Tesseract()
    vertices = tess.vertices
    edges = tess.edges
  }

  //Alleen om te kunnen zien of een model is veranderd
  override def toString = {
    var dragged = ""  
    	for (i <- 0 until vertices.size) {
				if (vertices(i).isDragged){
					dragged = dragged +"<" + i +">"
				}}
    //val test = vertices(0).location.x
    //val sumX:Double = vertices.reduceLeft((a,b) => a.location.x + b.location.x)//wat doe ik fout?
    val sumX = vertices.foldLeft(0.0)(_+_.location.x)
    val sumY = vertices.foldLeft(0.0)(_+_.location.y)
    "[SomX: " + sumX.toInt + ", somY: "+ sumY.toInt + dragged + "]"
  }

}

