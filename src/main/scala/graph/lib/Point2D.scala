package graph.lib

class Point2D {

  var x: Double = 0.0
  var y: Double = 0.0

  
  def this(theX: Double, theY: Double) = {
    this()
    x = theX
    y = theY
  }
  def distance(other:Point2D):Double = {
    math.sqrt(
        ((x-other.x)*(x-other.x))+
        ((y-other.y)*(y-other.y))
    )
  }
  
  override def toString():String= {
    "(" + x + "," + y + ")"
  }
}


