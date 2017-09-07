package graph.gui

import graph.model._
import scala.collection.mutable.ArrayBuffer
//import graph.model.GraphModel

class Expander (model: TGraphModel, writer: FBGPainting  ) {
//  def expandGraph(model: TGraphModel/*, zoom:Int*/):TGraphModel = {
  var mTeller = 0 //Alleen voor testen
  def tel = {
    mTeller = mTeller+1
    writer.taText("teller: "+ mTeller)
  }
  def expandGraph(model: TGraphModel/*, zoom:Int*/):Unit = {}
			val edges: Grid = model.edges
			val vertices: ArrayBuffer[Vertex3D] = model.vertices
			recalcGraphAsNeeded()

	private def recalcGraphAsNeeded(): Unit = {
			  tel
    recalcGraph(vertices, edges)
			  tel
//    if (false) {
//      val avgMovement: Double = getAvgLastMovement
////      Lib.melding("AvgMovement: " + str(avgMovement),
////                  "ForceBasedGraphPaintingPanel.recalcGraphAsNeeded")
//    }
      repeatAsNeeded(vertices, edges)
//  }
		
			//model//voorlopig
  }

  
 //HIER KOMT-IE NIET DOORHEEN
  def recalcGraph(vertices: ArrayBuffer[Vertex3D],edges: Grid): Unit = /*double mouseX, double mouseY*/ {
    for (i <- 0 until vertices.size) {
 //// loop through vertices
      var v: Vertex3D = vertices(i)
      var u: Vertex3D = null
 ////resetForce
      v.setNet_force(0, 0, 0)
      for (j <- 0 until vertices.size) {
 //// loop through other vertices
        if (i != j){ // else continue
          u = vertices(j)
          v.addRepulsion(u)
 //        
// ////        //kijken of ik uberhaupt iets zie veranderen
// ////        val extra:Int =50
// ////        v.location.x =v.location.x + extra
// ////        v.location.y =v.location.y + extra
        }    
      }
      for (j <- 0 until vertices.size) {
 //// loop through edges
        if (edges.isConnected(i, j)){ //else continue
          u = vertices(j)
          v.addAttraction(u)
          v.addCenterForce(/*zoom*/)
        }
      }
      v.addDamping()
      //Het lijkt of-ie het doet (hij gebruikt een variabel aantal recalulaties),
      //maar niet het model aanpast:
    }
 ////Lib.melding( vertices.toString(),"ForceBasedGraphPaintingPanel.recalcGraph()");
 ////    repaint()
    //  moveVertices(vertices) //Toegevoegd. Biedt geen soelaas
  }

  private def repeatAsNeeded(vertices: ArrayBuffer[Vertex3D],edges: Grid): Unit = {
    var avgMovement: Double = 10
    val epsilon: Double = 1
    var teller: Int = 0
    tel
    try{
      while ((avgMovement > epsilon) && (teller < 25)) {
    
     tel
      avgMovement = getAvgLastMovement(vertices)
////Lib.melding( "AvgMovement: " + str(avgMovement), "ForceBasedGraphPaintingPanel.repeatAsNeeded" );
      moveVertices(vertices)
      recalcGraph(vertices, edges) //{ teller += 1; teller - 1 }
      }
      } catch {
      case e: Exception => {
//        Lib.melding("Fout: " + e,
//                    "ForceBasedGraphPaintingPanel.repeatAsNeeded")
        return
      }

    }
  }

  private def getAvgLastMovement(vertices: ArrayBuffer[Vertex3D]): Double = {
    var totalMovement: Double = 0
    for (vertex3D <- vertices) {
      totalMovement += vertex3D.getLastMovement
    }
    totalMovement / vertices.size
  }

  private def moveVertices(vertices: ArrayBuffer[Vertex3D]): Unit = {
    for (i <- 0 until vertices.size) {
// set new positions
      val v: Vertex3D = vertices(i)
      v.move()
    }
  }
  


}