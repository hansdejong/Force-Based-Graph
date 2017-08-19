package main.scala.uitproberen

import scala.scalajs.js.annotation.JSExportTopLevel
import scalajs.js.annotation.JSExport

class Paintercv(html.Canvas){
  //constructor zonder canvas?
  var color ="red"
  def init()={}
  def changeColor(newColor:String): Unit={
    color=newColor
    println("The color is now: " + color)
  }
  //do things on canvas
}

@JSExportTopLevel("MethodUser")
object MethodUser {
   var schilder:Painter = new Painter() //een object wat niets spontaan mag doen
   
   
 @JSExportTopLevel("setColor")
  def setColor(color: String): Unit = {
   //How to change the painters color?
     
  }
 
  @JSExport
   def main(canvas: html.Canvas) = {
     schilder = new Painter(canvas)
     schilder.init()
   }
  
}