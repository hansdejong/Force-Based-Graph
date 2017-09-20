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

       val checkVertex = (vertex:Vertex3D) => {
         if(model.VertexContains(vertex, pointCursor)){
           vertex.setDragged(true)
           oneConnected = true
         }
         else{
           vertex.setDragged(false)
         }
       }
       
       model.vertices.map( checkVertex )
       dragging=oneConnected
  }
  
  def dragVertex( xCursor: Int, yCursor: Int): Unit = {
    val drag = (vertex:Vertex3D) => {
      val z: Int = vertex.getZ
      if (vertex.isDragged) vertex.setXYZ(xCursor, yCursor, z)
    }
    
    model.vertices.map(drag)
  }

}