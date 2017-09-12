package graph.view
import graph.model._
import graph.view._
import graph.lib._
import org.scalajs.dom
//Zoom nodig?
class Dragger(model: TGraphModel, writer: FBGPainting ) {
  
   def dragVertex( xCursor: Int, yCursor: Int): Unit = {
    for (i <- 0 until model.vertices.size) {
      var v: Vertex3D = model.vertices(i)
      val z: Int = v.getZ
      if (v.isDragged) v.setXYZ(xCursor, yCursor, z)
    }
   }

}