package tutorial.webapp

import scala.scalajs.js.annotation.JSExportTopLevel

import org.scalajs.jquery.jQuery

object TutorialApp {
  def main(args: Array[String]): Unit = {
    jQuery(() => setupUI())
  }

  def setupUI(): Unit = {
    jQuery("""<button type="button">Click me!</button>""")
      .click(() => addClickedMessage())
      .appendTo(jQuery("body"))
    jQuery("body").append("<p>Hello World</p>")
  }

  def addClickedMessage(): Unit = {
    jQuery("body").append("<p>You clicked the button!</p>")
  }
}
