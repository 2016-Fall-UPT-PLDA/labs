package plda.week11

/**
  *
  * @author Lorand Szakacs, lorand.szakacs@busymachines.com, lsz@lorandszakacs.com
  * @since 06 Dec 2016
  *
  *        http://scalapuzzlers.com/#pzzlr-051
  *
  */
object Puzzler10Comparison extends App {

  object Playroom {

    case class Toy(squeezeMsg: String = this.toString) {
      override def toString: String = squeezeMsg
    }

  }

  import Playroom._

  println(Toy("My name is Fido!") == new Toy("My name is Fido!"))
  println(Toy() == new Toy())

  //  println("-------")
  //  println(Toy())
  //  println(new Toy())
}
