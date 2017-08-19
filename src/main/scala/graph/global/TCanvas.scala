package graph.global

import org.scalajs.dom
import dom.html

trait TCanvas {//argument mag niet. Zie PiSc 419 PreInitialized Fields.
	val canvas: html.Canvas   // = Globals.gCanvas.get  //Dangerous
	val context = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
	canvas.width = canvas.parentElement.clientWidth
	canvas.height = canvas.parentElement.clientHeight
	val canvasWidth = canvas.width 
	val canvasHeight = canvas.height 
	var currentColor:String = Globals.gColor //gColor direct gebruiken
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
  		context.font = "20px Arial"
  		context.fillText(text,x,y)
  }
  var mouseDown = false
  canvas.onmousedown = (e: dom.MouseEvent) => mouseDown = true
  
  canvas.onmouseup = (e: dom.MouseEvent) => mouseDown = false
  
  canvas.onmousemove = { (e: dom.MouseEvent) =>
  		if (mouseDown)
  		  	onDragged(e)
  		else 
  				onMoved(e)
  }
  def onMoved(e: dom.MouseEvent){//add whatever
  
  }
  
  def onDragged(e: dom.MouseEvent){//add whatever
  	  //Later sleep of wijzig afhankelijk van mode 
  	  scratch(e)
  }
  
  //Vanaf  hier van Scratchpad, verhuizen voor handhaven =====================================
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
  
  testDrawing()
  def testDrawing() ={
    canvasBgColor( "#a6F611")
    //canvasBgColor( "pink")
    drawText("Hallo allemaal",10,50)
    drawCircle(95,80,40, "yellow")
    paintface()
    drawLine(150,250, 130,160)
    drawLine (0 ,0 , canvasWidth, canvasHeight)
  }
  
  def scratch(e: dom.MouseEvent) = {
  	  context.fillStyle = Globals.gColor
  		val rect = canvas.getBoundingClientRect()
  		context.fillRect( e.clientX - rect.left, e.clientY - rect.top, 10, 10)
  }
}


/*

	context.fillStyle = "#a6F611" //voorlopig
			//Van scratchpad 
			canvas.onmousedown =
					(e: dom.MouseEvent) => 
			{
				mx=e.clientX; my=e.clientY
				mouseIsDown = true
				onPressed()  
			}

			canvas.onmouseup =
					(e: dom.MouseEvent) =>
			{
				mx=e.clientX; my=e.clientY
				mouseIsDown = false  
				onReleased()
			}

			canvas.onmousemove = {
					(e: dom.MouseEvent) =>
					{
						mx=e.clientX; my=e.clientY
						if (mouseIsDown){
							onDragged()  
						}
						else{
							onMoved()
						}
					}
					//          val rect =
					//            canvas.getBoundingClientRect()
					//          if (mouseIsDown) context.fillRect(
					//            e.clientX - rect.left,
					//            e.clientY - rect.top,
					//            10, 10
					//          )
			}
			//Te gebruiken door client:
			var mouseIsDown:Boolean = false
			var mx=0.0
			var my=0.0
			//Better move handlers to the cliient 
			def onPressed(){//add whatever

			}
			def onReleased(){//add whatever

			}

 */

