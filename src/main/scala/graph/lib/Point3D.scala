package graph.lib

class Point3D {

  var x: Double = 0.0

  var y: Double = 0.0

  var z: Double = 0.0

  def this(theX: Double, theY: Double, theZ: Double) = {
    this()
    x = theX
    y = theY
    z = theZ
  }
  override def toString():String= {
    "(" + x + "," + y + "," + z + ")"
  }
}

