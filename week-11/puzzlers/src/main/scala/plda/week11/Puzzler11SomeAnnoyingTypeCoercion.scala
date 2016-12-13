package plda.week11

/**
  *
  * @author Lorand Szakacs, lorand.szakacs@busymachines.com, lsz@lorandszakacs.com
  * @since 06 Dec 2016
  *
  *        http://scalapuzzlers.com/#pzzlr-058
  */
object Puzzler11SomeAnnoyingTypeCoercion extends App {

  final val useFloats = false

  println(if (useFloats) 5.0f else '5')
  println((if (useFloats) 5.0f else '5').toString)

}
