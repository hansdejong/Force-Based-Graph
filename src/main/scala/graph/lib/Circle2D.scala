package graph.lib

class Circle2D {

  var m: Point2D = new Point2D(0.0,0.0)
  var r: Double = (1.0)

  
  def this(theM: Point2D, theR: Double) = {
    this()
    m = theM
    r = theR
  }
  def contains(p:Point2D):Boolean = {
    if ( m.distance(p) <= r) true else false
  }
  override def toString():String={
  "[(" + m.x + "," + m.y + ")-(" + r +")]"  
  }
}

