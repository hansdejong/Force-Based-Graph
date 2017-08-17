package graph.opstart
/*** 
 * Afgezien van de objectnaam begonnen als een kopie van Scratchpad (en zou moeten tekenen)
 * Eerst wil ik de mogelijke communicatiemanieren met de FBG.html uitproberen, 
 * daarna pas andere klassen betrekken: 
 * Ik krijg een referentie binnen naar Canvas --> daar op tekenen
 * Iets schrijven in een tekstvak
 * Reageren op een knop
 * Misschen een slider uitlezen of zelfs een kleur kiezen
 * Dit aLLES LIEFST ZONDER JqUERY 
*/
import org.scalajs.dom
import dom.document    //1. later er uit
import scala.scalajs.js.annotation.JSExportTopLevel
import scalajs.js.annotation.JSExport
import dom.html
import canvasapp._
import sierpinski._
import graph.gui._
/* [warn] /home/hans/scalaJS/CanvasApp fromTemplate/CanvasAppJS/src/main/scala/graph/opstart/StartGraph.scala:
 * 18: @JSExport on objects is deprecated and will be removed in 1.0.0. Use @JSExportTopLevel instead. 
 *  Note that it exports the object itself (rather than a 0-arg function returning the object), 
 *  so the calling JavaScript code must be adapted.
 *  Voorbeeld: https://github.com/scala-js/scala-js-dom/blob/master/example/src/main/scala/example/Example.scala
 *  @JSExport bij object moet er kennelijk uit. Misschien, maar dan wel met toplevel  
 */

@JSExportTopLevel("StartGraph")
object StartGraph{ 
 
  
  //1. Gebruikt DOM. Later er uit
  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)
  }

  @JSExportTopLevel("SCALA_nodes")
  def SCALA_nodes( noNodes:Int ): Unit = {
    appendPar(document.body, "Aantal nodes nu ingesteld op " + noNodes)
  }
  @JSExportTopLevel("SCALA_edges")
  def SCALA_edges( noEdges:Int ): Unit = {
    appendPar(document.body, "Aantal connecties nu ingesteld op " + noEdges)
  }
  @JSExportTopLevel("SCALA_zoom")
  def SCALA_zoom( zoom:Int ): Unit = {
    appendPar(document.body, "Zoom-factor nu ingesteld op " + zoom)
  }
  @JSExportTopLevel("SCALA_volgende")
  def SCALA_volgende(): Unit = {
    appendPar(document.body, "Je klikte op de VOLGENDE knop!")
  }
  @JSExportTopLevel("SCALA_kiesKleur")
  def SCALA_kiesKleur(kleur: String): Unit = {
    Globals.gColor = kleur 
    appendPar(document.body, "De volgende kleur is nu actief: " + kleur)
  }
  @JSExportTopLevel("SCALA_onToggle")
  def SCALA_onToggle(waarde: Int): Unit = {
    val keuze = waarde match{
      case 0 => "wijzig"
      case 1 => "sleep"
      case _ => "pardon?"  
    }
    appendPar(document.body, "Toggle is nu: " + keuze)
  }
//Tijdelijk. Bedoeld voor combo die het soort applicatie zou moeten instellen
  @JSExportTopLevel("SCALA_app")
  def SCALA_app(waarde: Int): Unit = {
    val keuze = waarde match{
      case 1 => "Sierpinski"
      case 2 => "Scratchpad"
      case 3 => "FBG"
      case _ => "pardon?"  
    }
    appendPar(document.body, "Applicatie is nu: " + keuze)
  }

  //Voor het starten van willekeurige tests in scala
  @JSExportTopLevel("SCALA_test")
  def SCALA_test(): Unit = {
    //Hier als eerste een testroutine van de canvas-interface trait
     appendPar(document.body, "De Scala test-knop")
  }
  
  @JSExport //Is dit goed of moet het TopLevel zijn?  
  def main(canvas: html.Canvas, tekstvak: html.TextArea) = {
    tekstvak.defaultValue = "Huidige app:" + Globals.app
    Globals.app match{
      case "FBG" => runFBG(canvas, tekstvak)
      case "ScratchPad" => ScratchPad.runScratchPad(canvas)
      case "Sierpinski" => ScalaJSExample.runSierpinski(canvas)
      case _ => println ("Foutje in StartGraph.loadCanvas")
          
      
    }
    
    def runFBG(canvas: html.Canvas, tekstvak: html.TextArea):Unit = {
       val gui: GraphGui = new GraphGui(canvas, tekstvak)
    }
  }
  
}

