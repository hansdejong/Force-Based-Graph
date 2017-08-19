package graph.gui
//
//import java.awt.BasicStroke
//
import java.awt.Color
import graph.global._
//
//import java.awt.Graphics2D
//
//import java.awt.Shape
//
//import java.awt.event.InputEvent
//
//import java.awt.event.MouseEvent
//
//import java.awt.event.MouseListener
//
//import java.awt.event.MouseMotionListener
//
//import java.awt.geom.Ellipse2D
//
//import java.awt.geom.Line2D
//
//import java.awt.geom.Point2D

import scala.collection.mutable.ArrayBuffer

import graph.drawings.EDrawings._
//
import graph.controller.EditGraphController
//
import graph.controller.TGraphController
//
//import fimme.graph.lib.Lib
//
import graph.drawings.EDrawings
import graph.model.GraphModel

import graph.model.Grid

import graph.model.TGraphModel

import graph.model.Vertex3D
import org.scalajs.dom
import dom.html
//
//
////remove if not needed
//import scala.collection.JavaConversions._
//
class FBGPaintingPanel(cv: html.Canvas, ta: html.TextArea) extends{
  val canvas = cv
  val textarea = ta
} with TCanvas with TTextArea {
def setCanvasColor(kleur:String):Unit ={
  cvColor = kleur
  //Is er nog ergens een notification nodig?
  //Anders is er geen setter nodig
}
////(/*canvas*/)//(/* canvas: html.Canvas,
//                           //         tekstvak: html.TextArea*/
//                                  /*numVertices: Int,
//                                   maxNumEdges: Int,
//                                   theBgColor: String,   //Color,
//                                   private var drawWithLabels: Boolean
//                                   */
//                         //          )
//    //extends AbstractPaintingPanel(/*canvas*/)
////    extends TCanvas//(/*canvas*/)
////    with MouseListener
////    with MouseMotionListener

}
 //============Declarations=============================================================
// //============Body logic ==============================================================
//  private var graph:EDrawings = getRandomDrawing
//  private var model: TGraphModel =  new GraphModel( graph )
//  private var graphController: TGraphController = new EditGraphController( model)
//  
// //============Kies een Begin-drawing===================================================
//   private def getRandomDrawing(): EDrawings = {
//    val graph = EDrawings(scala.util.Random.nextInt(EDrawings.maxId))
// //    println(ClassTag(graph.getClass))
// //   println(graph)
//   graph 
// }
 //===================================================================================== 
//} 
////  def appendText(extra:String)={ tekstvak.value = tekstvak.value + extra }
////  appendText("\nDit is FBGPaintingPanel")
//  
//  //var model: TGraphModel = new GraphModel(numVertices, maxNumEdges)
//  private var model: TGraphModel =  new GraphModel(RANDOM) //iets verzinnen. Dit niet dan is alles random
//
//  private var vertices: ArrayBuffer[Vertex3D] = model.vertices
//
//  private var edges: Grid = model.edges
//  private var drawWithLabels: Boolean = false
////
//////Anders editMode
////  private var draggingMode: Boolean = true
////
//  private var graphController: TGraphController = new EditGraphController( model)
////
////  private var defaultVertexColor: Color = Color.YELLOW
////
////  private var zoom: Double = 1
////
////  addMouseListener(this)
////
////  addMouseMotionListener(this)
////
////  /*vertices, edges*/
////
//  //this.background = theBgColor //Swingfunctie
////
//  def this (/*canvas: html.Canvas, tekstvak: html.TextArea,*/ numVertices: Int, maxNumEdges: Int, theBgColor: String,   //Color,
//                                   withLabels: Boolean
//                                   ) = {
////    this(canvas, tekstvak)
//      this()
//       drawWithLabels = withLabels
//       model = new GraphModel(numVertices, maxNumEdges)
//     //  this.background = theBgColor
//                                       
//  }
//  def this(/*canvas: html.Canvas, tekstvak: html.TextArea,*/ graphName: EDrawings, theBgColor: String/*Color*/, withLabels: Boolean) = {
////    this(canvas,tekstvak)
//      this()
////    addMouseListener(this)
////    addMouseMotionListener(this)
//    drawWithLabels = withLabels
//    model = new GraphModel(graphName)
//    vertices = model.vertices
//    edges = model.edges
//    graphController = new EditGraphController(model)
//   //  this.background = theBgColor //Swingfunctie
//  }
// 
//    
//    
////  def setNewModel(numVertices: Int, maxNumEdges: Int): Unit = {
////    model = new GraphModel(numVertices, maxNumEdges)
////    vertices = model.getVertices
////    edges = model.getEdges
////    graphController = new EditGraphController(model)
////    draggingMode = true
////  }
////
////  def setNewModel(drawing: EDrawings): Unit = {
////    model = new GraphModel(drawing)
////    vertices = model.getVertices
////    edges = model.getEdges
////    graphController = new EditGraphController(model)
////    draggingMode = true
////  }
////
////  def setNewModel(theModel: IGraphModel): Unit = {
////    model = theModel
////    vertices = model.getVertices
////    edges = model.getEdges
////    graphController = new EditGraphController(model)
////    draggingMode = true
////  }
////
////  def setDragMode(dragMode: Boolean): Unit = {
////    draggingMode = dragMode
////  }
////
////  def setDefaultVertexColor(color: Color): Unit = {
////    defaultVertexColor = color
////  }
////
////  def setZoomFactor(zoomFactor: Double): Unit = {
////    zoom = zoomFactor
////  }
//////Lib.melding("Zoomfactor nu "+ zoom ,"ForceBasedGraphPaintingPanel.setZoomFactor()");
//////Lib.melding("Zoomfactor nu "+ zoom ,"ForceBasedGraphPaintingPanel.setZoomFactor()");
////
////  override def paintAnything(g2D: Graphics2D): Unit = {
////    drawEdges(g2D)
////    drawVertices(g2D)
////    if (graphController.getVertexIsDraggedForEditing) {
////      drawEditingLine(g2D)
////    }
////  }
//
//
//  //override  def paintAnything(ctx: dom.CanvasRenderingContext2D): Unit = {
////    drawEdges(ctx)
////    drawVertices(ctx)
////    if (graphController.getVertexIsDraggedForEditing) {
////      drawEditingLine(ctx)
////    }
////  }
//
////  private def drawVertices(g2D: Graphics2D): Unit = {
//////Miste, Toegevoegd
////    for (vertex3D <- vertices) {
////      drawVertex(g2D, vertex3D)
////    }
////  }
//
//  private def drawVertices(ctx: dom.CanvasRenderingContext2D): Unit = {
//    for (vertex3D <- vertices) {
//      drawVertex(ctx, vertex3D)
//    }
//  }
//  
////  def drawVertex(gr: Graphics2D, vertex: Vertex3D): Unit = {
////    val xScreen: Double = vertex.getX / zoom
////    val yScreen: Double = vertex.getY / zoom
////    val color: Color = vertex.getColor
////    val label: String = vertex.getLabel
////    val r: Double = Vertex3D.getRadius / zoom
////    val shape: Shape =
////      new Ellipse2D.Double(xScreen - r, yScreen - r, 2 * r, 2 * r)
////    gr.setStroke(new BasicStroke(1))
////    gr.setColor(color)
////    gr.fill(shape)
////    gr.setColor(Color.BLACK)
////    gr.draw(shape)
////    if (drawWithLabels) {
////      gr.drawString(label, xScreen.toInt + 15, yScreen.toInt)
////    }
////  }
//  
//  def drawVertex(ctx: dom.CanvasRenderingContext2D, vertex: Vertex3D): Unit = {
///*
//    val xScreen: Double = vertex.getX / zoom
// 
//    val yScreen: Double = vertex.getY / zoom
//    val color: Color = vertex.getColor
//    val label: String = vertex.getLabel
//    val r: Double = Vertex3D.getRadius / zoom
//    val shape: Shape =
//      new Ellipse2D.Double(xScreen - r, yScreen - r, 2 * r, 2 * r)
//    ctx.setStroke(new BasicStroke(1))
//    ctx.setColor(color)
//    ctx.fill(shape)
//    ctx.setColor(Color.BLACK)
//    ctx.draw(shape)
//    if (drawWithLabels) {
//      ctx.drawString(label, xScreen.toInt + 15, yScreen.toInt)
//    }
// */
//  }
//  
//////gr.drawString( "" + (int)xScreen + ", " + (int)yScreen, (int)xScreen+15, (int)yScreen);
//////gr.drawString( "" + (int)xScreen + ", " + (int)yScreen, (int)xScreen+15, (int)yScreen);
////
////  private def drawEdges(g2D: Graphics2D): Unit = {
//////Lib.melding( edgesToString(),"ForceBasedGraphPaintingPanel.drawEdges");
////    g2D.setStroke(new BasicStroke(1))
////    g2D.setColor(new Color(0x333333))
////    for (i <- 0 until vertices.size; j <- 0 until vertices.size) {}
//////CONVERTER PROBLEEM
//////                if(! edges.isConnected(i, j) ) continue;
//////        		int x1 = (int)(vertices.get(i).getX() / zoom);
//////        		int y1 = (int)(vertices.get(i).getY() / zoom);
//////        		int x2 = (int)(vertices.get(j).getX() / zoom);
//////        		int y2 = (int)(vertices.get(j).getY() / zoom);
//////        		g2D.drawLine( x1, y1, x2, y2 );
//////CONVERTER PROBLEEM
//////                if(! edges.isConnected(i, j) ) continue;
//////        		int x1 = (int)(vertices.get(i).getX() / zoom);
//////        		int y1 = (int)(vertices.get(i).getY() / zoom);
//////        		int x2 = (int)(vertices.get(j).getX() / zoom);
//////        		int y2 = (int)(vertices.get(j).getY() / zoom);
//////        		g2D.drawLine( x1, y1, x2, y2 );
////  }
//////Verplaatsen?
//////Verplaatsen?
//
////gr.drawString( "" + (int)xScreen + ", " + (int)yScreen, (int)xScreen+15, (int)yScreen);
////gr.drawString( "" + (int)xScreen + ", " + (int)yScreen, (int)xScreen+15, (int)yScreen);
//
//  private def drawEdges(ctx: dom.CanvasRenderingContext2D): Unit = {/*
////Lib.melding( edgesToString(),"ForceBasedGraphPaintingPanel.drawEdges");
//    ctx.setStroke(new BasicStroke(1))
//    ctx.setColor(new Color(0x333333))
//    for (i <- 0 until vertices.size; j <- 0 until vertices.size) {}
//CONVERTER PROBLEEM
//                if(! edges.isConnected(i, j) ) continue;
//        		int x1 = (int)(vertices.get(i).getX() / zoom);
//        		int y1 = (int)(vertices.get(i).getY() / zoom);
//        		int x2 = (int)(vertices.get(j).getX() / zoom);
//        		int y2 = (int)(vertices.get(j).getY() / zoom);
//        		drawLine( x1, y1, x2, y2.ctx )
//CONVERTER PROBLEEM
//                if(! edges.isConnected(i, j) ) continue;
//        		int x1 = (int)(vertices.get(i).getX() / zoom);
//        		int y1 = (int)(vertices.get(i).getY() / zoom);
//        		int x2 = (int)(vertices.get(j).getX() / zoom);
//        		int y2 = (int)(vertices.get(j).getY() / zoom);
//        		g2D.drawLine( x1, y1, x2, y2 );*/
//  }
////Verplaatsen?
////Verplaatsen?
//
////  private def drawEditingLine(g2D: Graphics2D): Unit = {
////    val line: Line2D.Double = (graphController.getDraggingLine)
////  }
//  private def drawEditingLine(ctx: dom.CanvasRenderingContext2D): Unit = {
//    //val line: Line2D.Double = (graphController.getDraggingLine)
//  }
////  /*
////		int x1Screen = (int)(line.x1 / zoom);
////		int y1Screen = (int)(line.y1 / zoom);
////		int x2Screen = (int)(line.x2 / zoom);
////		int y2Screen = (int)(line.y2 / zoom);
////		g2D.drawLine(  x1Screen, y1Screen, x2Screen, y2Screen );
////   */
////
////  /*
////		int x1Screen = (int)(line.x1 / zoom);
////		int y1Screen = (int)(line.y1 / zoom);
////		int x2Screen = (int)(line.x2 / zoom);
////		int y2Screen = (int)(line.y2 / zoom);
////		g2D.drawLine(  x1Screen, y1Screen, x2Screen, y2Screen );
////   */
////
//////Draw the Graph
////  private def dragVertex(xModel: Int, yModel: Int): Unit = {
////    updateVertices(xModel, yModel)
////    recalcGraphAsNeeded()
////  }
////
////  private def updateVertices(xModel: Double, yModel: Double): Unit = {
////    for (i <- 0 until vertices.size) {
////// set new positions
////      val v: Vertex3D = vertices.get(i)
////      val z: Int = v.getZ
////      if (v.isDragged) {
////        v.setXYZ(xModel, yModel, z)
////      } else {
////        v.move()
////      }
////    }
////  }
////
////  private def recalcGraphAsNeeded(): Unit = {
////    recalcGraph()
////    if (false) {
////      val avgMovement: Double = getAvgLastMovement
////      Lib.melding("AvgMovement: " + str(avgMovement),
////                  "ForceBasedGraphPaintingPanel.recalcGraphAsNeeded")
////    }
////    repeatAsNeeded()
////  }
////
////  def recalcGraph(): Unit = /*double mouseX, double mouseY*/ {
////    for (i <- 0 until vertices.size) {
////// loop through vertices
////      val v: Vertex3D = vertices.get(i)
////      var u: Vertex3D = null
//////resetForce
////      v.setNet_force(0, 0, 0)
////      for (j <- 0 until vertices.size) {
////// loop through other vertices
////        if (i == j) //continue
////          u = vertices.get(j)
////        v.addRepulsion(u)
////      }
////      for (j <- 0 until vertices.size) {
////// loop through edges
////        if (!edges.isConnected(i, j)) //continue
////          u = vertices.get(j)
////        v.addAttraction(u)
////        v.addCenterForce(zoom)
////      }
////      v.addDamping()
////    }
//////Lib.melding( vertices.toString(),"ForceBasedGraphPaintingPanel.recalcGraph()");
////    repaint()
////  }
////
////  private def repeatAsNeeded(): Unit = {
////    var avgMovement: Double = 10
////    val epsilon: Double = 1
////    var teller: Int = 0
////    try while ((avgMovement > epsilon) && (teller < 25)) {
////      avgMovement = getAvgLastMovement
//////Lib.melding( "AvgMovement: " + str(avgMovement), "ForceBasedGraphPaintingPanel.repeatAsNeeded" );
////      moveVertices()
////      recalcGraph() { teller += 1; teller - 1 }
////    } catch {
////      case e: Exception => {
////        Lib.melding("Fout: " + e,
////                    "ForceBasedGraphPaintingPanel.repeatAsNeeded")
////        return
////      }
////
////    }
////  }
////
////  private def getAvgLastMovement(): Double = {
////    var totalMovement: Double = 0
////    for (vertex3D <- vertices) {
////      totalMovement += vertex3D.getLastMovement
////    }
////    totalMovement / vertices.size
////  }
////
////  private def moveVertices(): Unit = {
////    for (i <- 0 until vertices.size) {
////// set new positions
////      val v: Vertex3D = vertices.get(i)
////      v.move()
////    }
////  }
////
//////mouseListener = new MouseAdapter(){
////  def mousePressed(event: MouseEvent): Unit = {
////    val xModel: Double = event.getX * zoom
////    val yModel: Double = event.getY * zoom
////    val pointModel: Point2D.Double = new Point2D.Double(xModel, yModel)
//////showPoints( pointModel/*, point*/);//TODO
////    if (draggingMode) {
////      for (vertex3D <- vertices) {
////        vertex3D.setDragged(model.VertexContains(vertex3D, pointModel))
////      }
////    } else {
////      val leftButton: Boolean = (event.getModifiers == InputEvent.BUTTON1_MASK)
////      val foundVertex: Int = model.findFirstVertex(pointModel)
////      if (foundVertex != -1) {
////        if (!leftButton) {
//////Lib.melding( "RechterMuisknop", "ForceBasedGraphPaintingPanel.mousePressed()" );
////          model.setVertexColor(foundVertex, defaultVertexColor)
////        } else {
////          graphController.onMouseIsPressed(leftButton, foundVertex)
////        }
////      } else if (model.findEdge(pointModel)) {
////        graphController.removeEdge(model.getLastFoundEdgeVertex1,
////                                   model.getLastFoundEdgeVertex2)
////      }
////    }
////    repaint()
////  }
////
////  override def mouseReleased(event: MouseEvent): Unit = {
////    val xModel: Double = event.getX * zoom
////    val yModel: Double = event.getY * zoom
////    val pointModel: Point2D.Double = new Point2D.Double(xModel, yModel)
//////Lib.melding("Omhoog: " + x + ", " + y, "ForceBasedGraphPaintingPanel.mouseReleased");
////    if (draggingMode) {
////      for (vertex3D <- vertices) {
////        vertex3D.setDragged(false)
////      }
////    } else {
//////is al maal zoom
////      val foundVertex: Int = model.findFirstVertex(pointModel)
////      graphController.onMouseIsReleased(pointModel, foundVertex)
////    }
//////Lib.melding( "Release before recalc ", "ForceBasedGraphPaintingPanel.mouseReleased");
//////Lib.melding( "Release before recalc ", "ForceBasedGraphPaintingPanel.mouseReleased");
////    recalcGraphAsNeeded()
////  }
//////repaint();
//////repaint();
////
//////mouseMotionListener = new MouseMotionAdapter(){
////  def mouseDragged(event: MouseEvent): Unit = {
////    val xModel: Double = event.getX * zoom
////    val yModel: Double = event.getY * zoom
////    val pointModel: Point2D.Double = new Point2D.Double(xModel, yModel)
////    if (draggingMode) {
//////Lib.melding("Slepen: " + x + ", " + y, "ForceBasedGraphPaintingPanel.mouseDragged");
////      dragVertex(xModel.toInt, yModel.toInt)
////    } else {
////      graphController.onMouseIsDragged(pointModel)
////    }
////    repaint()
////  }
////
///////*
////  override def mouseClicked(arg0: MouseEvent): Unit = {}
////
////  override def mouseEntered(arg0: MouseEvent): Unit = {}
////
////  override def mouseExited(arg0: MouseEvent): Unit = {}
////
////  override def mouseMoved(arg0: MouseEvent): Unit = {}
////
////  private def str(d: Double): String = Lib.formatDouble(d)
////
//}
//
