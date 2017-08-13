//package graph.controller
//
//import java.awt.geom.Line2D
//
//import java.awt.geom.Point2D
//
//import java.util.ArrayList
//
//import fimme.graph.model.Grid
//
//import fimme.graph.model.IGraphModel
//
//import fimme.graph.model.Vertex3D
//
//class EditGraphController(var model: IGraphModel) extends TGraphController {
//
//// I can drag the new edge
//  private var vertexIsChosen: Boolean = false
//
//  private var vertexIsDragged: Boolean = false
//
//  private var foundVertexPressed: Int = 0
//
//  private var foundVertexReleased: Int = 0
//
//  private var draggingCursor: Point2D.Double = new Point2D.Double(0, 0)
//
//  def setVertexIsDragged(dragged: Boolean): Unit = {
//    vertexIsDragged = dragged
//  }
//
//  def getVertexIsDraggedForEditing(): Boolean = vertexIsDragged
//
//  def getDraggingLine(): Line2D.Double =
//    if (vertexIsDragged) {
//      val vertices: ArrayList[Vertex3D] = model.getVertices
//      val x1: Double = vertices.get(foundVertexPressed).getX
//      val y1: Double = vertices.get(foundVertexPressed).getY
//      val p1: Point2D.Double = new Point2D.Double(x1, y1)
//      val p2: Point2D.Double = draggingCursor
//      new Line2D.Double(p1, p2)
//    } else null
//
//  def onMouseIsPressed(leftButton: Boolean, pressedVertex: Int): Unit = {
//    if (pressedVertex != -1) {
////Lib.melding("Vertex3D " + foundVertexPressed, "EditGraphController.mouseIsPressed");
//      foundVertexPressed = pressedVertex
//      vertexIsChosen = true
//    }
//  }
//
//  def onMouseIsReleased(point: Point2D.Double, releasedVertex: Int): Unit = {
//    if (vertexIsDragged) {
//      if (releasedVertex != -1) {
//        foundVertexReleased = releasedVertex
//        connectVertices()
//      } else {
//        makeVertex(point)
//      }
//      vertexIsDragged = false
//      vertexIsChosen = false
//    }
//  }
//
//  def onMouseIsDragged(point: Point2D.Double): Unit = {
//    if (vertexIsChosen) vertexIsDragged = true
//    draggingCursor = point
//  }
//
//  def removeEdge(foundEdgeVertex1: Int, foundEdgeVertex2: Int): Unit = {
//    model.removeEdge(foundEdgeVertex1, foundEdgeVertex2)
//  }
////		Grid edges = model.getEdges();
////		edges.setConnected( foundEdgeVertex1, foundEdgeVertex2, false);
////		Grid edges = model.getEdges();
////		edges.setConnected( foundEdgeVertex1, foundEdgeVertex2, false);
//
//  private def connectVertices(): Unit = {
//    val edges: Grid = model.getEdges
//    edges.setConnected(foundVertexPressed, foundVertexReleased, true)
//  }
//
////Edges en vertices moeten naar het graphmodel-interface
//  private def makeVertex(point: Point2D.Double): Unit = {
//    val vertices: ArrayList[Vertex3D] = model.getVertices
//    val edges: Grid = model.getEdges
//    val vertex3D: Vertex3D = new Vertex3D()
//    vertex3D.setXYZ(point.x, point.y, 0)
//    edges.setConnected(foundVertexPressed, vertices.size, true)
//    vertices.add(vertex3D)
//  }
//
//}
//
