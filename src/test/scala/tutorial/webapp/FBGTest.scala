package tutorial.webapp

import utest._
import graph.model._
import graph.drawings._
//import org.scalajs.jquery.jQuery
//http://www.lihaoyi.com/post/uTesttheEssentialTestFrameworkforScala.html

object FBGTest extends TestSuite {
  // Initialize App
  val testClass = new FBGTest
  def tests = TestSuite {
    assert(testClass.model.vertices.length ==3) //FakeTest
  }
  class FBGTest{
    val model:TGraphModel = new GraphModel(EDrawings.STICK)
  }
}
