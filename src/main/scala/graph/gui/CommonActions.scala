package graph.gui
import graph.model._
import graph.gui._
import graph.lib._
import org.scalajs.dom

class CommonActions(model: TGraphModel, writer: FBGPainting ) {
  
  //Deze routine ook gebruiken in wijzigmodel. Hernoemen en verplaatsen.
  //Dit was connectDragger
  def connectVertex(/*e: dom.MouseEvent, */pointModel: Point2D) = {
    writer.taAppendText ("Cursor "+ pointModel.x + "," + pointModel.y)
       for (vertex3D <- model.vertices) {
          vertex3D.setDragged(model.VertexContains(vertex3D, pointModel))
       }
       for (vertex3D <- model.vertices; if(vertex3D.isDragged)) 
            writer.taText("raak")
  }

}