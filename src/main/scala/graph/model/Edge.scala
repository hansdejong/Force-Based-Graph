package graph.model

class Edge {
  var length: Double = 1
  var connected: Boolean = false
  override def toString() = if(connected) "+" else "-"
}

