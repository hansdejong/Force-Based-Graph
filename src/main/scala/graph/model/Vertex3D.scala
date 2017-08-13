//package graph.model
//
//import java.awt.Color
//
//import java.io.Serializable
//
//import fimme.graph.lib.Lib
//
//import Vertex3D._
//
//object Vertex3D {
//
//
//  var radius: Int = 12
//
//}
//
//class Vertex3D extends Comparable[Vertex3D] {
//
//// location. Toegevoegd. Beter in Sprite?
//  var location: Point3d = new Point3d()
//
//  var color: Color = getRandomColor
//
//// speed of vertex
//  var velocity: Point3d = new Point3d()
//
//// force towards other vertices in the network
//  var net_force: Point3d = new Point3d()
//
//  var label: String = ""
//
//// I can drag the vertice
//  var isDragged: Boolean = false
//
//////For stop_criterium
//  private var movement: Double = 100
//
//  def this(theColor: Color) = {
//    this()
//    color = theColor
//  }
//
//  def setNet_force(xForce: Double, yForce: Double, zForce: Double): Unit = {
//    val newPoint: Point3d = new Point3d(xForce, yForce, zForce)
//    net_force = newPoint
//  }
//
//  private def getRandomColor(): Color = {
//    val R: Int = (Math.random() * 255).toInt
//    val G: Int = (Math.random() * 255).toInt
//    val B: Int = (Math.random() * 255).toInt
//    new Color(R, G, B)
//  }
//
//  def setXYZ(x: Double, y: Double, z: Double): Unit = {
////Lib.melding( "yyy","Vertex3D.setXYZ()");
//    val newPoint: Point3d = new Point3d(x, y, z)
//    location = newPoint
//  }
//
//  def getX(): Int = location.x.toInt
//
//  def getY(): Int = location.y.toInt
//
//  def getZ(): Int = location.z.toInt
//
//  def getLastMovement(): Double = movement
//
////Als addAttraction, maar naar vast centraal punt
//  def addCenterForce(zoomFactor: Double): Unit = {
//    val scaling: Double = 0.00001
//    val vx: Double = location.x
//    val vy: Double = location.y
//    val vz: Double = location.z
//    val cx: Double = 600 * zoomFactor
//    val cy: Double = 400 * zoomFactor
//    val cz: Double = 200 * zoomFactor
//    net_force.x += scaling * (cx - vx)
//    net_force.y += scaling * (cy - vy)
//    net_force.z += scaling * (cz - vz)
//  }
//
//  def addRepulsion(other: Vertex3D): Unit = {
//    val scaling: Double = 200
//    val vx: Double = location.x
//    val vy: Double = location.y
//    val vz: Double = location.z
//    val ux: Double = other.location.x
//    val uy: Double = other.location.y
//    val uz: Double = other.location.z
//    val distanceSquared: Double = (vx - ux) * (vx - ux) + (vy - uy) * (vy - uy) + (vz - uz) * (vz - uz)
//    net_force.x += scaling * (vx - ux) / distanceSquared
//    net_force.y += scaling * (vy - uy) / distanceSquared
//    net_force.z += scaling * (vz - uz) / distanceSquared
//  }
//
//  def setBoundingBox(a: Point3d, b: Point3d): Unit = {
//    if (a.x >= b.x || a.y >= b.y || a.z >= b.z) {
//      Lib.melding("Verkeerde Box-Co�rdinaten", "Vertex3D.setBoundingBox")
//      return
//    }
//    if (location.x < a.x) location.x = a.x
//    if (location.y < a.y) location.y = a.y
//    if (location.z < a.z) location.z = a.z
//    if (location.x > b.x) location.x = b.x
//    if (location.y > b.y) location.y = b.y
//    if (location.z > b.z) location.z = b.z
//  }
//
//  def addAttraction(other: Vertex3D): Unit = {
//    val scaling: Double = 0.06
//    val vx: Double = location.x
//    val vy: Double = location.y
//    val vz: Double = location.z
//    val ux: Double = other.location.x
//    val uy: Double = other.location.y
//    val uz: Double = other.location.z
//    net_force.x += scaling * (ux - vx)
//    net_force.y += scaling * (uy - vy)
//    net_force.z += scaling * (uz - vz)
//  }
//
//  def addDamping(): Unit = {
//    val scaling: Double = 0.85
//    val vel_x: Double = velocity.x
//    val vel_y: Double = velocity.y
//    val vel_z: Double = velocity.z
//    val force_x: Double = net_force.x
//    val force_y: Double = net_force.y
//    val force_z: Double = net_force.z
//    velocity.x = scaling * (vel_x + force_x)
//    velocity.y = scaling * (vel_y + force_y)
//    velocity.z = scaling * (vel_z + force_z)
//  }
//
//  def setDragged(dragged: Boolean): Unit = {
//    isDragged = dragged
//  }
//
//  def move(): Unit = {
////Lib.melding( "yyy","Vertex3D.move()");
//    val oldx: Double = location.x
//    val oldy: Double = location.y
//    val oldz: Double = location.z
//    val newx: Double = oldx + velocity.x
//    val newy: Double = oldy + velocity.y
//    val newz: Double = oldz + velocity.z
//    location.x = newx
//    location.y = newy
//    location.z = newz
//    movement = Math.sqrt(
//      (newx - oldx) * (newx - oldx) + (newy - oldy) * (newy - oldy) +
//        (newz - oldz) * (newz - oldz))
//  }
//
//  override def toString(): String = {
//    val result: String = "Vertex3D " + str(location.x) + ", " + str(location.y) +
//        ", " +
//        str(location.z) +
//        "\n"
//    result
//  }
//
//  private def str(d: Double): String = Lib.formatDouble(d)
//
//  override def compareTo(other: Vertex3D): Int = {
//    val ty: Double = this.location.y
//    val oy: Double = other.location.y
//    if ((ty < oy)) -1 else (if ((ty == oy)) 0 else 1)
//  }
//
//}
//
//
