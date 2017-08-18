package graph.global

import org.scalajs.dom
import dom.html

trait TCanvas {
	val canvas: html.Canvas = Globals.gCanvas.get  //Dangerous
	val context = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
  
  
//Vanaf  hier van Scratchpad  ============================================
  
      canvas.width = canvas.parentElement.clientWidth
      canvas.height = canvas.parentElement.clientHeight
  
  //    renderer.fillStyle = "#f8f8f8"
      context.fillStyle = "#a6F611" //Dit lijkt niets te doen
      context.fillRect(0, 0, canvas.width, canvas.height)
  
      /*code*/
      context.fillStyle = Globals.gColor
  
      var down = false
      canvas.onmousedown =
        (e: dom.MouseEvent) => down = true
  
      canvas.onmouseup =
        (e: dom.MouseEvent) => down = false
  
      canvas.onmousemove = {
        (e: dom.MouseEvent) =>
          val rect =
            canvas.getBoundingClientRect()
          if (down) context.fillRect(
            e.clientX - rect.left,
            e.clientY - rect.top,
            10, 10
          )
      }
    

/*
	val cvColor:String = Globals.gColor
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
			def onMoved(){//add whatever

			}
			def onDragged(){//add whatever
			  fromCanvasApp
			}
			
			def fromCanvasApp{
          val rect =
					canvas.getBoundingClientRect()
					if (mouseIsDown) context.fillRect( mx - rect.left, my - rect.top, 10, 10 )
			}

*/
			//    canvas.width = canvas.parentElement.clientWidth
			//    canvas.height = canvas.parentElement.clientHeight
			//    private val width: Int = canvas.width //private weg?
			//    private val height: Int = canvas.height
			//    
			////
			////  private var buffer: BufferedImage = null
			////
			////  private var g2Dbuffer: Graphics2D = null
			//    val ctx = canvas.getContext("2d")
			//                     .asInstanceOf[dom.CanvasRenderingContext2D]
			//    ctx.fillStyle = "#f8f8f8"
			//    ctx.fillRect(0, 0, canvas.width, canvas.height)



			//         //Kijken of ik was te zien krijg: weer weg
			//        drawLine (10,15,200,300,ctx)
			//
			//    def drawLine(x1:Double,y1:Double,x2:Double,y2:Double,ctx: dom.CanvasRenderingContext2D):Unit={
			//      ctx.moveTo(x1, y1)
			//      ctx.lineTo(x1, y1)
			//    }
			////  def paintAnything(g2D: Graphics2D): Unit
			//    def paintAnything(ctx: dom.CanvasRenderingContext2D): Unit

			//             drawLine(0, 0, 15, 10, ctx)
			//        paintAnything(ctx)



}