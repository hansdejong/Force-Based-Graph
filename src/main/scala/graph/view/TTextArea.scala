package graph.view

import org.scalajs.dom
import dom.html

trait TTextArea {
  val textarea: html.TextArea //= Globals.gTextArea.get //Dangerous
  def taText(text:String) = { textarea.value = text } 
  def taAppendText(text:String) = { textarea.value = textarea.value + text } 
}