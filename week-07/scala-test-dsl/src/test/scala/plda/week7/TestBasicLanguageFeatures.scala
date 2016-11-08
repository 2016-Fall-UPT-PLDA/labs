//package plda.week7
//
//import org.scalatest.FlatSpec
//
//import scala.util.{Failure, Try}
//
///**
//  *
//  * @author Lorand Szakacs, lorand.szakacs@busymachines.com, lsz@lorandszakacs.com
//  * @since 08 Nov 2016
//  *
//  */
//class TestBasicLanguageFeatures extends FlatSpec {
//
//  "scala" should "... do stuff" in {
//    println {
//      "10-9430"
//    }
//
//    MyShould("randomString").myShould
//
//    "I" twoP(42, 41)
//
//
//    val answerToLife = 42
//    val x = when(answerToLife == 42) {
//      answerToLife * 42
//    }
//  }
//
//  def when[T](boolean: Boolean)(thunk: => T): Option[T] = {
//    if (boolean) {
//      Some(thunk)
//    } else {
//      None
//    }
//  }
//
//
//  implicit class MyShould(val string: String) {
//    def myShould: MyShouldVerb = new MyShouldVerb()
//
//    def twoP(p: Int, p1: Int): Int = p + p1
//  }
//
//  case class MyShouldVerb(
//    x: Int
//  )
//
//  class MyShouldVerbose(
//    val x: Int
//  )
//
//  val cc = MyShouldVerb(42)
//  cc.x
//
//  val nc = new MyShouldVerbose(42)
//  nc.x
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
