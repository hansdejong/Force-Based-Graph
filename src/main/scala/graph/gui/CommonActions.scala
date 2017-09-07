package graph.gui
import graph.model._
import graph.gui._
import graph.lib._
import org.scalajs.dom

class CommonActions(model: TGraphModel, writer: FBGPainting ) {
  var lastFoundVertexIndex = -1
  
  //Deze routine ook gebruiken in wijzigmodel. Hernoemen en verplaatsen.
  //Dit was connectDragger
  def connectVertex(/*e: dom.MouseEvent, */pointCursor: Point2D):Boolean = {
    writer.taAppendText ("Cursor "+ pointCursor.x + "," + pointCursor.y)
       var oneConnected:Boolean  = false
       var index = -1
       for (vertex3D <- model.vertices) {
         index=index+1 //beginnen bij 0
         if(model.VertexContains(vertex3D, pointCursor)){
           vertex3D.setDragged(true)
           oneConnected = true
           lastFoundVertexIndex = index
           }
         else
           vertex3D.setDragged(false)
       }
       //Dit er weer uit:
       for (vertex3D <- model.vertices; if(vertex3D.isDragged)) 
            writer.taText("raak")
       oneConnected
  }

}