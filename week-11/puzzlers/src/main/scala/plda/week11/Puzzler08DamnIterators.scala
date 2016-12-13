package plda.week11

/**
  *
  * @author Lorand Szakacs, lorand.szakacs@busymachines.com, lsz@lorandszakacs.com
  * @since 06 Dec 2016
  *
  *        http://scalapuzzlers.com/#pzzlr-048
  *
  */
object Puzzler08DamnIterators extends App {

  val oneTwo = Seq(1, 2).permutations
  if (oneTwo.length > 0) {
    println("Permutations of 1 and 2:")
    oneTwo foreach println
  }

  println("--------")

  val threeFour = Seq(3, 4).permutations
  if (!threeFour.isEmpty) {
    println("Permutations of 3 and 4:")
    threeFour foreach println
  }

}
