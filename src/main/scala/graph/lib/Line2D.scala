package graph.lib


class Line2D {

  var a: Point2D = new Point2D(0.0,0.0)
  var b: Point2D = new Point2D(0.0,0.0)
  
  def this(theA: Point2D, theB: Point2D) = {
    this()
    a = theA
    b = theB
  }
  override def toString():String={
  "[(" + a.x + "," + a.y + ")-(" + b.x + "," +b.y +")]"  
  }
}

