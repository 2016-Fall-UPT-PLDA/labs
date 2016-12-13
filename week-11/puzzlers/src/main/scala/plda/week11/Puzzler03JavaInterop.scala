package plda.week11

/**
  *
  * @author Lorand Szakacs, lorand.szakacs@busymachines.com, lsz@lorandszakacs.com
  * @since 06 Dec 2016
  *
  *
  * http://scalapuzzlers.com/#pzzlr-035
  *
  */
object Puzzler03JavaInterop extends App {

  def objFromJava: java.lang.Object = "string"

  def stringFromJava: String = null

  def printLengthIfString(a: AnyRef) {
    a match {
      case s: String => println(s"String of length ${s.length}")
      case _ => println("Not a string")
    }
  }

  printLengthIfString(objFromJava)
  printLengthIfString(stringFromJava)

}
