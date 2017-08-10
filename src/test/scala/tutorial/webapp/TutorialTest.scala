package tutorial.webapp

import utest._
import org.scalajs.jquery.jQuery

object TutorialTest extends TestSuite {

  // Initialize App
  TutorialApp.setupUI()

  def tests = TestSuite {
    'HelloWorld {
      //length is het aantal <p>'s met de betreffende tekst
      assert(jQuery("p:contains('Hello World met jQuery')").length == 1)
    }

    'ButtonClick {
      def messageCount =
        jQuery("p:contains('You clicked the jQuery button!')").length

      val button = jQuery("button:contains('Click me jQ!')")
      assert(button.length == 1)
      assert(messageCount == 0)

      for (c <- 1 to 5) {
        button.click()
        assert(messageCount == c)
      }
    }

  }
}
