package graph.view

import org.scalajs.dom
import dom.html
import graph.global.Global

/**Strategie: de muiscode hier houden. Los van wat variabelen subclasses 
 * alleen laten werken met implementaties van abstracte classen.
 */
//Argument mag niet bij trait. Zie PiSc 419 PreInitialized Fields.

trait TCanvas {
	val canvas: html.Canvas
	val context = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
	canvas.width = canvas.parentElement.clientWidth
	canvas.height = canvas.parentElement.clientHeight
	val canvasWidth = canvas.width 
	val canvasHeight = canvas.height 
	var currentColor:String = Global.gColor //gColor direct gebruiken
	def canvasBgColor(bgColor:String) = {
  	context.fillStyle = bgColor 
	  context.fillRect(0, 0, canvasWidth, canvasHeight)
  }
  def drawLine(x1: Double, y1: Double, x2: Double, y2: Double)={    
  		context.strokeStyle = "black"
  		context.lineWidth = 1
  		context.beginPath()
  		context.moveTo(x1, y1)
  		context.lineTo(x2, y2)
  		context.stroke()
  }   
  def drawCircle(x: Double,y: Double,r: Double, color: String) = {
  		context.beginPath()
  		context.arc(x,y,r,0,2*Math.PI)
  		context.fillStyle = color
  		context.fill()
  		context.fillStyle = "black"
  		context.stroke()
  }
  def drawText(text:String, x: Double, y: Double):Unit = {
  		context.fillStyle = "black"  
  		context.font = "12px Arial"
  		context.fillText(text,x,y)
  }
  var mouseDown = false
  canvas.onmousedown = (e: dom.MouseEvent) => {
      mouseDown = true; onPressed(e) }
  canvas.onmouseup = (e: dom.MouseEvent) => {
      mouseDown = false; onReleased(e) }
  canvas.onmousemove = (e: dom.MouseEvent) =>{
  		if (mouseDown) onDragged(e)
  		else           onMoved(e) }
  //Abstract. Te implementeren door subclass
  def onMoved(e: dom.MouseEvent)
  def onDragged(e: dom.MouseEvent)
  def onReleased(e: dom.MouseEvent)
  def onPressed(e: dom.MouseEvent)
}


