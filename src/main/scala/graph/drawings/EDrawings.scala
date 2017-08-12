package graph.drawings


object EDrawings extends Enumeration {

  val RANDOM: EDrawings = new EDrawings()

  val CUBE: EDrawings = new EDrawings()

  val BUCKYBALL: EDrawings = new EDrawings()

  val MOBIUS: EDrawings = new EDrawings()

  val DOUGHNUT: EDrawings = new EDrawings()

  val TESSERACT: EDrawings = new EDrawings()

  val SNAKE: EDrawings = new EDrawings()

  val SNAKERING: EDrawings = new EDrawings()

  val SIMPLEX4: EDrawings = new EDrawings()

  val DODECAEDER: EDrawings = new EDrawings()

  val SPUTNIK: EDrawings = new EDrawings()

  class EDrawings extends Val

  implicit def convertValue(v: Value): EDrawings = v.asInstanceOf[EDrawings]

}

