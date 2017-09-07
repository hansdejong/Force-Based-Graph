package graph.gui
import graph.model._
import graph.gui._
import graph.lib._
import org.scalajs.dom

class Dragger(model: TGraphModel, writer: FBGPainting ) {
  
   def dragVertex( xCursor: Int, yCursor: Int): Unit = {
    for (i <- 0 until model.vertices.size) {
      var v: Vertex3D = model.vertices(i)
      val z: Int = v.getZ
      if (v.isDragged) v.setXYZ(xCursor, yCursor, z)
    }
   }

}