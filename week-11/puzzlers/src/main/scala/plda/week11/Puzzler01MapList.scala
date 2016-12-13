package plda.week11

/**
  *
  * @author Lorand Szakacs, lorand.szakacs@busymachines.com, lsz@lorandszakacs.com
  * @since 06 Dec 2016
  *
  *        http://scalapuzzlers.com/#pzzlr-001
  *
  */
object Puzzler01MapList extends App {

  def p[T](place: String)(thunk: => T): Unit = {
    println(s"----- $place ------")
    println(thunk)
    println("")
  }

  def puzzler(): Unit = {

    p("1st") {
      List(1, 2).map { i => i + 1 }
    }

    p("2nd") {
      List(1, 2, 3).map { i => println(s"Hi"); i + 1 }
    }
    p("3rd, should be same as 1st") {
      List(1, 2).map {
        _ + 1
      }
    }

    p("4th should be same as 2nd") {
      List(1, 2, 3).map {
        println("Hi")
        (i: Int) => i + 1
      }
    }
  }

  puzzler()

}
