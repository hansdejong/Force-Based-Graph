package canvasapp

import org.scalajs.dom
import dom.html
import graph.global._

object ScratchPad {

  def runScratchPad(canvas: html.Canvas):Unit = {
      /*setup*/
      val ctx = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
  
      canvas.width = canvas.parentElement.clientWidth
      canvas.height = canvas.parentElement.clientHeight
  
      //Let op"dit is de achtergrondkleur
      ctx.fillStyle =   "#f8f8c8" 
      ctx.fillRect(0, 0, canvas.width, canvas.height)
  
      //En dit de voorgrondkleur, wordt niet ververst
      ctx.fillStyle = "blue" //Global.gColor
  
      var down = false
      canvas.onmousedown =
        (e: dom.MouseEvent) => down = true
  
      canvas.onmouseup =
        (e: dom.MouseEvent) => down = false
  
      canvas.onmousemove = {
        (e: dom.MouseEvent) =>
          val rect =
            canvas.getBoundingClientRect()
          if (down) ctx.fillRect(
            e.clientX - rect.left,
            e.clientY - rect.top,
            10, 10
          )
      }
    }
}
