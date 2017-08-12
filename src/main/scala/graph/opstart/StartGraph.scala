package graph.opstart

/**
  * @copyright (C) Hans de Jong, 2010
  * @author Hans de Jong.<br><br>
  * The main entrancepoint of the application<br>
  */
import java.awt.Color

import java.awt.event.WindowAdapter

import java.awt.event.WindowEvent

import javax.swing._

import fimme.graph.gui.GraphGui

//import fimme.graph.lib.Lib;
import fimme.graph.lib.Lib

import StartGraph._

object StartGraph {

// indicates whether frame should be packed
  private var packFrame: Boolean = false

  private var myFrame: JFrame = null

//Einde init()
  def setStaticTitleCallBack(title: String): Unit = {
    myFrame.setTitle("Force-Based Graph: " + title)
  }

//Voor applicatie:
  def main(args: Array[String]): Unit = {
    try UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName)
    catch {
      case e: Exception => Lib.melding("Fout: " + e, "StartGraph.main()")

    }
    myFrame = new JFrame("Force-Based Graph")
    myFrame.setSize(500, 450)
    myFrame.setResizable(true)
    myFrame.setVisible(true)
    myFrame.setBackground(Color.lightGray)
    myFrame.addWindowListener(new WindowAdapter() {
      def windowClosing(e: WindowEvent): Unit = {
        if (e.getID == WindowEvent.WINDOW_CLOSING) {
          System.exit(0)
        } else if (e.getID == WindowEvent.WINDOW_ACTIVATED) {
          e.getWindow.repaint()
        }
      }
    })
    val isApplet: Boolean = false
    val gui: GraphGui = new GraphGui(isApplet)
    myFrame.add(gui)
// layout or validate frames that have preset sizes.
    if (packFrame) {
      myFrame.pack()
    } else {
      myFrame.validate()
    }
    myFrame.setVisible(true)
  }
// Pack frames that have useful preferred size info. from their
// Pack frames that have useful preferred size info. from their

}

class StartGraph extends JApplet {

//voor applet:
  def init(): Unit = {
    try UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName)
    catch {
      case e: Exception => Lib.melding("Fout:" + e, "StartGraph.init()")

    }
    try {
      val isApplet: Boolean = true
      val gui: GraphGui = new GraphGui(isApplet)
      getContentPane.add(gui)
    } catch {
      case e: Exception => Lib.melding("Fout: " + e, "StartGraph.init()")

    }
  }

}

