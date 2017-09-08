package graph.drawings

import scala.collection.mutable.ArrayBuffer
import graph.model.Grid
import graph.model.Vertex3D

trait TDrawing {
  var vertices: ArrayBuffer[Vertex3D]
  var edges: Grid
}

