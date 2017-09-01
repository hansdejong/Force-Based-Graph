package graph.gui
import graph.model._
import graph.gui._
import graph.lib._
import org.scalajs.dom

class Dragger(model: TGraphModel, writer: FBGPainting ) {
  
  def connectDragger(/*e: dom.MouseEvent, */pointModel: Point2D) = {
    writer.taAppendText ("Cursor "+ pointModel.x + "," + pointModel.y)
       for (vertex3D <- model.vertices) {
          vertex3D.setDragged(model.VertexContains(vertex3D, pointModel))
       }
       for (vertex3D <- model.vertices; if(vertex3D.isDragged)) 
            writer.taText("raak")
  }
   def dragVertex( xModel: Int, yModel: Int): Unit = {
     //////Draw the Graph
////  private def dragVertex(xModel: Int, yModel: Int): Unit = {
     
      //writer.taAppendText("dragger1 "+ model) //Dit blijkt hetzelfde model
     
       //even eruit Maakt dit alles nul? Ja/ Dragger2 is pas nul
     updateVertices(xModel, yModel)
       /// writer.taAppendText("dragger2 "+ model) //Dit blijkt hetzelfde model
       
       
////    recalcGraphAsNeeded()
////  }

   }
 def releaseDragger() = {
    ////      for (vertex3D <- vertices) {
    ////        vertex3D.setDragged(false)
    ////      }

  }
 
 
 /**
  * Hier gaat het fout. Proberen:
  * - v mag misschien geen val zijn. Nee, lost het in ieder geval niet op.
  * - Proberen met alleen maar move() => worden nul
  * - Proberen zonder move() => geen nullen (maar wel identiek, dus setXYZ werkt ook niet !? 
  * En ook maar 1 keer. Verlies ik de referentie?)
  * Conclusie: move() is de schuldige, maar ziet er heel onschuldig uit
  * */
  private def updateVertices(xModel: Double, yModel: Double): Unit = {
    for (i <- 0 until model.vertices.size) {
// set new positions
      var v: Vertex3D = model.vertices(i)
      val z: Int = v.getZ
      if (v.isDragged) {
        v.setXYZ(xModel, yModel, z)
      } else {
       // v.move()
      }
    }
  }

}