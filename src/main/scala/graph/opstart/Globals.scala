package graph.opstart

object Globals {
  val welke = 3
  val app = welke match{
    case 1 => "Sierpinski"
    case 2 => "ScratchPad"
    case 3 => "FBG"
    case _ => "Oeps"
  }
  var gColor = "red"
  
}