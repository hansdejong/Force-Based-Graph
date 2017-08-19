package graph.global

import org.scalajs.dom
import dom.html

trait TTextArea {
  val textarea: html.TextArea //= Globals.gTextArea.get //Dangerous
  def taAppendText(extra:String) = { textarea.value = textarea.value + extra } 
}