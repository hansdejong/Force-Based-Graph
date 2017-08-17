package graph.global

import org.scalajs.dom
import dom.html

trait TCanvas {
     val canvas: html.Canvas = Globals.gCanvas.get 
     val cvColor:String = Globals.gColor
   

  
}