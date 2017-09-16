package graph.view

import graph.model._
import scala.collection.mutable.ArrayBuffer

class Expander (model: TGraphModel, writer: FBGPainting  ) {
	val edges: Grid = model.edges
	val vertices: ArrayBuffer[Vertex3D] = model.vertices
	
  var mTeller = 0 //Alleen voor testen
  
  def expandGraph(model: TGraphModel):Unit = {
			recalcGraphAsNeeded()
	}

	private def tel = {
    mTeller = mTeller+1
    //writer.taText("teller: "+ mTeller + "\n")
  }

	private def recalcGraphAsNeeded(): Unit = {
		//tel
    recalcGraph(vertices, edges)
		//tel
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
    var teller: Int = 0
    
    //Geeft indicatie voor aantal iteraties
    mTeller = 0;tel
    
    try{
      while ((avgMovement > epsilon) && (teller < 25)) {
        //tel
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
    for (vertex3D <- vertices) {
      totalMovement += vertex3D.getLastMovement
    }
    totalMovement / vertices.size
  }

  private def moveVertices(vertices: ArrayBuffer[Vertex3D]): Unit = {
    for (i <- 0 until vertices.size) {
      val v: Vertex3D = vertices(i)
      v.move()
    }
  }
  


}