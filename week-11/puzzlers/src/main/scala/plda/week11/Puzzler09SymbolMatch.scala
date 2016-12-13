package plda.week11

/**
  *
  * @author Lorand Szakacs, lorand.szakacs@busymachines.com, lsz@lorandszakacs.com
  * @since 06 Dec 2016
  *
  *        http://scalapuzzlers.com/#pzzlr-050
  *
  */
object Puzzler09SymbolMatch extends App {

  val nObj: Object = null
  val n = null

  println {
    nObj match {
      case Symbol(x) => x
      case _ => "Not a symbol"
    }
  }
  println("-------------")

  println {
    n match {
      case Symbol(x) => x
      case _ => "Not a symbol"
    }
  }

}
