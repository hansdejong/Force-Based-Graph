package graph.view

import graph.model._
import scala.collection.mutable.ArrayBuffer

class Expander (model: TGraphModel, writer: FBGPainting  ) {
	val edges: Grid = model.edges
	val vertices: ArrayBuffer[Vertex3D] = model.vertices
	
  def expandGraph(model: TGraphModel):Unit = {
			recalcGraphAsNeeded()
	}

	private def recalcGraphAsNeeded(): Unit = {
    recalcGraph(vertices, edges)
    repeatAsNeeded(vertices, edges)
  }

  
  private def recalcGraph(vertices: ArrayBuffer[Vertex3D],edges: Grid): Unit = /*double mouseX, double mouseY*/ {
    for (i <- 0 until vertices.size) {
      //loop through vertices
      var v: Vertex3D = vertices(i)
      var u: Vertex3D = null
      //resetForce
      v.setNet_force(0, 0, 0)
      for (j <- 0 until vertices.size) {
        //loop through other vertices
        if (i != j){ // else continue
          u = vertices(j)
          v.addRepulsion(u)
        }    
      }
      for (j <- 0 until vertices.size) {
        //loop through edges
        if (edges.isConnected(i, j)){ //else continue
          u = vertices(j)
          v.addAttraction(u)
          v.addCenterForce()
        }
      }
      v.addDamping()
    }
  }

  private def repeatAsNeeded(vertices: ArrayBuffer[Vertex3D],edges: Grid): Unit = {
    var avgMovement: Double = 10
    val epsilon: Double = 1
//  var teller: Int = 0//wordt niet meer gebruikt
    
    try{
      while ((avgMovement > epsilon)/* && (teller < 25)*/) {
        avgMovement = getAvgLastMovement(vertices)
        moveVertices(vertices)
        recalcGraph(vertices, edges) //{ teller += 1; teller - 1 }
      }
    } catch {
      case e: Exception => {
        return
      }

    }
  }

  private def getAvgLastMovement(vertices: ArrayBuffer[Vertex3D]): Double = {
    var totalMovement: Double = 0
    vertices.map(totalMovement += _.getLastMovement)
    totalMovement / vertices.size
  }

  private def moveVertices(vertices: ArrayBuffer[Vertex3D]): Unit = {
     vertices.map(_.move)
  }
  


}