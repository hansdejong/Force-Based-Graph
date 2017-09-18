package graph.global

import org.scalajs.dom
import dom.document

object Global {
  /**Het is de bedoeling hier een enkele referentie te hebben naar html-objecten.
   * Als je alleen met vals wilt werken kun je de referentie alleen maar doorgeven, 
   * via constructors en argumenten: elegant en veilig, maar lastig.
   * Het alternatief is eerst een var (hier) te assignen, waar volgende initialisaties 
   * naar kunnen verwijzen. 
   * Wat ik wil proberen is om traits te maken, met een val die er bij instantiatie 
   * naar komt te verwijzen. Zo'n trait kan een complete interface naar het object
   * bevatten, dus in geval van een canvas alle tekenfuncties. 
   * Alle code die iets wil tekenen kan dan die trait gebruiken
   */    
  /**De variabelen hier moeten zijn geinitialiseerd
   * En als ik hier een lazy val gebruik met een functie die de waarde ophaalt uit StartGraph? 
   * */

  val gRelease:Boolean = true //weer terug naar true
  val gLabels:Boolean = false   //weer terug naar false
  
  var gColor: String = "red" //TOCH NOG HANDHAVEN
  var gDraggingMode: Boolean = true //anders "wijzig"
    var gZoom:Double = 1.0
  var gNodes:Int = 10
  var gEdges:Int = 20
  
  
  //gApp geeft de  actieve applicatie, in te stellen via "welke"
  val welke = 3
  val gApp = welke match{
    case 1 => "Sierpinski"
    case 2 => "ScratchPad"
    case 3 => "FBG"
    case _ => "Oeps"
  }
  
  def appendMsg( text: String): Unit = {
    if(!gRelease){
      val targetNode: dom.Node = document.body
      val parNode = document.createElement("p")
      val textNode = document.createTextNode(text)
      parNode.appendChild(textNode)
      targetNode.appendChild(parNode)
    }
  }

}