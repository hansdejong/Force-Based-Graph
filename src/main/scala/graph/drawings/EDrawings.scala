package graph.drawings


//object EDrawings extends Enumeration {
//  val RANDOM: EDrawings = new EDrawings()
//  val CUBE: EDrawings = new EDrawings()
//  val BUCKYBALL: EDrawings = new EDrawings()
//  val MOBIUS: EDrawings = new EDrawings()
//  val DOUGHNUT: EDrawings = new EDrawings()
//  val TESSERACT: EDrawings = new EDrawings()
//  val SNAKE: EDrawings = new EDrawings()
//  val SNAKERING: EDrawings = new EDrawings()
//  val SIMPLEX4: EDrawings = new EDrawings()
//  val DODECAEDER: EDrawings = new EDrawings()
//  val SPUTNIK: EDrawings = new EDrawings()
//
//  class EDrawings extends Val
//  implicit def convertValue(v: Value): EDrawings = v.asInstanceOf[EDrawings]
//}



//Nu volgens PrScala92
object EDrawings extends Enumeration {
  type EDrawings = Value
  val RANDOM = Value("Random")
  val CUBE = Value("Cube")
  val BUCKYBALL = Value("Buckyball")
  val MOBIUS = Value("Mobius")
  val DOUGHNUT = Value("Doughnut")
  val TESSERACT = Value("Tesseract")
  val SNAKE = Value("Snake")
  val SNAKERING = Value("SnakeRing")
  val SIMPLEX4 = Value("Simplex4")
  val DODECAEDER = Value("Dodecaeder")
  val SPUTNIK = Value("Sputnik")

 // class Edrawings{
//    val values = ValueSet(RANDOM, CUBE, BUCKYBALL, MOBIUS, DOUGHNUT,
//        TESSERACT,SNAKE, SNAKERING, SIMPLEX4, DODECAEDER, SPUTNIK)
  //}
  implicit def convertValue(v: Value): EDrawings = v.asInstanceOf[EDrawings]
}

