package graph.lib

class Line3D {

  var a: Point3D = new Point3D(0.0,0.0,0.0)

  var b: Point3D = new Point3D(0.0,0.0,0.0)

  var c: Point3D = new Point3D(0.0,0.0,0.0)

  def this(theA: Point3D, theB: Point3D, theC: Point3D) = {
    this()
    a = theA
    b = theB
    c = theC
  }
  override def toString():String={
  "[(" + a.x + "," + a.y + ")-(" + b.x + "," +b.y +")-(" + c.x + "," +c.y +")]"  
  }

}

