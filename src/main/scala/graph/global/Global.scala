package graph.global

import org.scalajs.dom
import dom.html
import dom.raw.ClientRect

object Global {
  /**Het is de bedoeling hier een enkele referentie te hebben naar html-objecten.
   * Als je alleen met vals wilt werken kun je de referentie alleen maar doorgeven, 
   * via constructors en argumenten: elegant en veilig, maar lastig.
   * Het alternatief is eerst een var (hier) te assignen, waar volgende initialisaties 
   * naar kunnen verwijzen. Wat ik wil proberen is om traits te maken, met een val die er bij
   * instantiatie naar komt te verwijzen. Zo'n trait kan een complete interface naar het object
   * bevatten, dus in geval van een canvas alle tekenfuncties. 
   * Alle code die iets wil tekenen kan dan die trait gebruiken
   */    
  /**De variabelen hier moeten zijn geinitialiseerd
   * En als ik hier een lazy val gebruik met een functie die de waarde ophaalt uit StartGraph? 
   * */
  //en in graph.global voor elk een trait te maken als interface om ze te benaderen
  //De html-objecten:
 // var gCanvas: html.Canvas
 // lazy val gCanvas = StartGraph.
 //// var gCanvas: Option[html.Canvas] = None   
 // var gTextArea: Option[html.TextArea] = None
  var gColor: String = "red" //TOCH NOG HANDHAVEN
  var gDraggingMode: Boolean = true //anders "wijzig"
  var gZoom_Int = 1
 // var canvasRect:ClientRect = new ClientRect()

  //gApp geeft de  actiev applicatie, in te stellen via "welke"
  val welke = 3
  val gApp = welke match{
    case 1 => "Sierpinski"
    case 2 => "ScratchPad"
    case 3 => "FBG"
    case _ => "Oeps"
  }
  
}