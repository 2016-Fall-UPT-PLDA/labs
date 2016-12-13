package plda.week11

/**
  *
  * @author Lorand Szakacs, lorand.szakacs@busymachines.com, lsz@lorandszakacs.com
  * @since 06 Dec 2016
  *
  *        http://scalapuzzlers.com/#pzzlr-047
  *
  */
object Puzzler07AbstractTypes extends App {

  type Dollar = Int
  final val Dollar: Dollar = 1
  val a: List[Dollar] = List(1, 2, 3)

  println(a map { a: Int => Dollar })
  println("-----")
  println(a.map(a: Int => Dollar))
  println(a.map(a.apply))


}
