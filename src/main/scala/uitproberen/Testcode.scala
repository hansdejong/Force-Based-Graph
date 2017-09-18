package uitproberen
import graph.model._
import graph.drawings._
import scala.reflect.ClassTag

//Dit draaien als applicatie, niet als Scala.js 

object Testcode {
  val scalaVersion = util.Properties.versionString
  def objectType(a:Any):String =  ClassTag(a.getClass).toString()

  def main(args: Array[String]){
    val cube1 = new GraphModel(EDrawings.CUBE)
    val cube2:TGraphModel = new GraphModel(EDrawings.CUBE)
    println (cube1)
    println (cube1.edges)
    println ("Scalaversion: " + scalaVersion)
    println (objectType(cube1))
    println (objectType(cube2))
  }  
}