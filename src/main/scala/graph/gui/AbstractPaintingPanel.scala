package graph.gui
//
///**
//  * De bedoeling is faciliteiten te bundelen voor een Graphics-panel.
//  * GEBRUIKSAANWIJZING:
//  * Teken of schrijf in paintAnything(), roep vervolgens repaint() aan.
//  * HEEFT:
//  * - Border en defaultafmetingen
//  * - Dubbele buffering
//  * - Graphics2D ipv. Graphics (G2D is een G-subclass met extra faciliteiten.)
//  * TODO:
//  * - Muis-listeners
//  * VERWIJZINGEN:
//  * Dubbele buffering: Examples Nutshell 306
//  *
//  */
//import java.awt.Color
//
//import java.awt.Dimension
//
//import java.awt.Graphics
//
//import java.awt.Graphics2D
//
//import java.awt.image.BufferedImage
//
//import javax.swing.BorderFactory
//
import javax.swing.JPanel
//
//import javax.swing.border.EtchedBorder
//
////remove if not needed
//import scala.collection.JavaConversions._
//
abstract class AbstractPaintingPanel extends JPanel {
//
//  private var width: Int = 1680
//
//  private var height: Int = 1050
//
//  private var buffer: BufferedImage = null
//
//  private var g2Dbuffer: Graphics2D = null
//
//  private var buffered: Boolean = true
//
//  private var bgColor: Color = null
//
////geeft applet rand!
//  this.border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED)
//
//  if (buffered) {
//    buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
//    g2Dbuffer = buffer.createGraphics()
//  }
//
//  setTheSize(width, height)
//
//  repaint()
//
//  def setTheSize(theWidth: Int, theHeight: Int): Unit = {
//    width = theWidth
//    height = theHeight
////Let op volgorde!
//    val dim: Dimension = new Dimension(height, width)
//    this.preferredSize = dim
//  }
//
//  def paintComponent(g: Graphics): Unit = {
//    super.paintComponent(g)
//    val g2D: Graphics2D = g.asInstanceOf[Graphics2D]
//    if (buffered) {
////Lib.melding("Gebufferd", "AbstractPaintingPanel.paintComponent()");
//      if (bgColor == null) bgColor = getBackground
//      g2Dbuffer.setColor(bgColor)
//      g2Dbuffer.fillRect(0, 0, buffer.getWidth, buffer.getHeight)
////drawBorder( g2Dbuffer );
//      paintAnything(g2Dbuffer)
//      g2D.drawImage(buffer, 0, 0, this)
//    } else {
//      g2D.drawLine(0, 0, 15, 10)
//      paintAnything(g2D)
//    }
//  }
//
//  private def drawBorder(g2D: Graphics2D): Unit = {
//    val lineColor: Color = Color.BLACK
//    val w: Int = buffer.getWidth
//    val h: Int = buffer.getHeight
////10 is te weinig. Maar waarom?
//    g2D.drawRect(10, 10, w - 15, h - 15)
//  }
////Lib.melding("width, height: " + w + ", " + h, "AbstractPaintingPanel.drawBorder()");
////Lib.melding("width, height: " + w + ", " + h, "AbstractPaintingPanel.drawBorder()");
//
//  def paintAnything(g2D: Graphics2D): Unit
//
}
