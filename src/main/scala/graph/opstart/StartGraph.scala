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
/* [warn] /home/hans/scalaJS/CanvasApp fromTemplate/CanvasAppJS/src/main/scala/graph/opstart/StartGraph.scala:
 * 18: @JSExport on objects is deprecated and will be removed in 1.0.0. Use @JSExportTopLevel instead. 
 *  Note that it exports the object itself (rather than a 0-arg function returning the object), 
 *  so the calling JavaScript code must be adapted.
 *  Voorbeeld: https://github.com/scala-js/scala-js-dom/blob/master/example/src/main/scala/example/Example.scala
 */

//@JSExport //Dit moet er kennelijk uit. Misschien, maar dan wel met toplevel

@JSExportTopLevel("graph.opstart.StartGraph") //Dit moet er kennelijk uit. Misschien, maar dan wel met toplevel
object StartGraph extends{

  //1. Gebruikt DOM. Later er uit
  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)
  }

  @JSExportTopLevel("klik_volgende")
  def klik_volgende(): Unit = {
    appendPar(document.body, "Je klikte op de VOLGENDE knop!")
  }
//  @JSExportTopLevel("toggle_mode")
//  def toggle_mode(mode:String): Unit = {
//    appendPar(document.body, "De toggle ging naar " + mode)
//  }
//  @JSExportTopLevel("color_picker")
//  def toggle_color_picker(): Unit = {
//    appendPar(document.body, "De colorpicker werkt nog niet")
//  }
//  @JSExportTopLevel("doe_iets")
//  def doe_iets(): Unit = {
//    appendPar(document.body, "De colorpicker werkt nog niet")
//  val text = dom.document.getElementById("test_text").asInstanceOf[AnyRef].getClass.getSimpleName
//    appendPar(document.body, text) //Lijkt me sterk dat dit lukt 
//  //asInstanceOf[TextField]
////	text.value="Eindelijk"
//  }

//  dom.document.getElementById("mainForm").asInstanceOf[HTMLFormElement]
//Hoe weet je het type?
// https://docs.webix.com/desktop__textarea.html
// Geeft veel info over velden, maar een expliciete cast?
// En als je de cast achterwege laat en toegestane eigenschappen gebruikt?
  
  @JSExport //Is dit goed of moet het TopLevel zijn?
  def main(canvas: html.Canvas) = {
    /*setup*/
    val renderer = canvas.getContext("2d")
                         .asInstanceOf[dom.CanvasRenderingContext2D]

    canvas.width = canvas.parentElement.clientWidth
    canvas.height = canvas.parentElement.clientHeight

    renderer.fillStyle = "#f8f8f8"
    renderer.fillRect(0, 0, canvas.width, canvas.height)

    /*code*/
//    renderer.fillStyle = "black"
    renderer.fillStyle = "red"
//    renderer.fillStyle = "orange"
    var down = false
    canvas.onmousedown =
      (e: dom.MouseEvent) => down = true

    canvas.onmouseup =
      (e: dom.MouseEvent) => down = false

    canvas.onmousemove = {
      (e: dom.MouseEvent) =>
        val rect =
          canvas.getBoundingClientRect()
        if (down) renderer.fillRect(
          e.clientX - rect.left,
          e.clientY - rect.top,
          10, 10
        )
    }
  }
}

