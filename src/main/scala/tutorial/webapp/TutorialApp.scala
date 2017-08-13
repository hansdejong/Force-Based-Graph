
package tutorial.webapp

import org.scalajs.dom //1. later er uit
import dom.document    //1. later er uit
import scala.scalajs.js.annotation.JSExportTopLevel
import org.scalajs.jquery.jQuery

object TutorialApp {
  //1. Gebruikt DOM. Later er uit
  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)
  }

  //Stap 4 Button via DOM
  @JSExportTopLevel("addClickedMessageDOM")
  def addClickedMessageDOM(): Unit = {
    appendPar(document.body, "You clicked the DOM button!")
  }

  def main(args: Array[String]): Unit = {
    //1. Gebruikt DOM. Later er uit
    appendPar(document.body, "Paragraaf met DOM")


    println("Hallo allemaal.\nDit zie je alleen terug in de webconsole!")//Toegevoegd Hans
    jQuery(() => setupUI())
  }

  def setupUI(): Unit = {
    jQuery("""<button type="button">Click me jQ!</button>""")
      .click(() => addClickedMessage())
      .appendTo(jQuery("body"))
    jQuery("body").append("<p>Hello World met jQuery</p>")
  }

  def addClickedMessage(): Unit = {
    jQuery("body").append("<p>You clicked the jQuery button!</p>")
  }

}

