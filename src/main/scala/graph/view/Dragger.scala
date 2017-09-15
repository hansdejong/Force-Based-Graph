package graph.view
import graph.model._
import graph.view._
import graph.lib._
import org.scalajs.dom
//Hier niet zoomen, is al gebeurd
class Dragger(model: TGraphModel, writer: FBGPainting ) {
  
  var dragging=false
  def checkOnSpot(pointCursor: Point2D):Unit = {
       var oneConnected:Boolean  = false
       var index = -1
       for (vertex3D <- model.vertices) {
         index=index+1 //beginnen bij 0
         if(model.VertexContains(vertex3D, pointCursor)){
           vertex3D.setDragged(true)
           oneConnected = true
           }
         else
           vertex3D.setDragged(false)
       }
       dragging=oneConnected
  }
  
  def dragVertex( xCursor: Int, yCursor: Int): Unit = {
    for (i <- 0 until model.vertices.size) {
      var v: Vertex3D = model.vertices(i)
      val z: Int = v.getZ
      if (v.isDragged) v.setXYZ(xCursor, yCursor, z)
    }
  }

}