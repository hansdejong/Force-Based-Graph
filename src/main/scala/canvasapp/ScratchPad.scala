package canvasapp

import org.scalajs.dom
import graph.opstart._
import dom.html

object ScratchPad {

  def runScratchPad(canvas: html.Canvas):Unit = {
      /*setup*/
      val ctx = canvas.getContext("2d")
                           .asInstanceOf[dom.CanvasRenderingContext2D]
  
      canvas.width = canvas.parentElement.clientWidth
      canvas.height = canvas.parentElement.clientHeight
  
  //    renderer.fillStyle = "#f8f8f8"
      ctx.fillStyle = "#a6F611" //Dit lijkt niets te doen
      ctx.fillRect(0, 0, canvas.width, canvas.height)
  
      /*code*/
      ctx.fillStyle = Globals.gColor
  
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
