package graph.view
import graph.model._
//import graph.view._
//import graph.lib._
import graph.global._
import org.scalajs.dom

//Oude testcode en tekenroutines
class Dismissed(model: TGraphModel, writer: FBGPainting ) {
  val context = writer.context
  val canvas = writer.canvas
  
  def scratch(e: dom.MouseEvent) = {
  	  context.fillStyle = Global.gColor
  		val rect = canvas.getBoundingClientRect()
  		context.fillRect( e.clientX - rect.left, e.clientY - rect.top, 10, 10)
  }
  testDrawing() 
  //Wordt vervangen  door clear()
  def testDrawing() ={
    writer.canvasBgColor( "#a6F611")
    //canvasBgColor( "pink")
    writer.drawText("Hallo allemaal",10,50)
    writer.drawCircle(95,80,40, "yellow")
    paintface()
    writer.drawLine(150,250, 130,160)
    writer.drawLine (0 ,0 , writer.canvasWidth, writer.canvasHeight)
  }
  def paintface()={    
  		val w = 300
  		context.strokeStyle = "purple"
  		context.lineWidth = 3
  		context.beginPath()
  		context.moveTo(w/3, 0)
  		context.lineTo(w/3, w/3)
  		context.moveTo(w*2/3, 0)
  		context.lineTo(w*2/3, w/3)
  		context.moveTo(w, w/2)
  		context.arc(w/2, w/2, w/2, 0, 3.14)
  		context.stroke()
  } 
}