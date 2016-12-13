package plda.week11

/**
  *
  * @author Lorand Szakacs, lorand.szakacs@busymachines.com, lsz@lorandszakacs.com
  * @since 06 Dec 2016
  *
  *        http://scalapuzzlers.com/#pzzlr-040
  *
  */
object Puzzler05ToSet extends App {

  def puzzler(): Unit = {
    val bool: Boolean = List("1", "2").toSet.apply(())
    val numbers = List("1", "2").toSet() + "3"
    println(numbers)
  }

  puzzler()
}
