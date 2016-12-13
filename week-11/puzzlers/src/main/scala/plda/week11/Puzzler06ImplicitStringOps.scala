package plda.week11

/**
  *
  * @author Lorand Szakacs, lorand.szakacs@busymachines.com, lsz@lorandszakacs.com
  * @since 06 Dec 2016
  *
  *        http://scalapuzzlers.com/#pzzlr-045
  *
  *
  */
object Puzzler06ImplicitStringOps extends App {

  class A {
    implicit val stringToInt = (_: String).toInt
    println("4" - 2)
  }

  class B {
    implicit val stringToInt: String => Int = _.toInt
    println("4" - 2)
  }

  new A()
  new B()
}
