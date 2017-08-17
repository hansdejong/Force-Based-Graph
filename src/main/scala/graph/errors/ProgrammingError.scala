package graph.errors

//remove if not needed
import scala.collection.JavaConversions._

/**
  * De gebruiker, maar ook de programmeur kan het verkeerd doen
  * Deze errors hoeven niet opgegeven in throws-clause
  */

class ProgrammingError(boodschap: String) extends RuntimeException {

  var strMessage: String = "ProgrammingError: " + boodschap

//  def this() = {
//    this
//
//  }

  override def toString(): String = strMessage

}

