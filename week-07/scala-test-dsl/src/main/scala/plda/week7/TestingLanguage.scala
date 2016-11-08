package plda.week7

/**
  *
  * @author Lorand Szakacs, lorand.szakacs@busymachines.com, lsz@lorandszakacs.com
  * @since 08 Nov 2016
  *
  */
object TestingLanguage extends TestingLanguage

trait TestingLanguage {
  type TestIdentifier = Int


  //  object test {
  //    def apply[T](testNr: TestIdentifier)(assertion: => (T, T)) = ???
  //  }

  //  def test(testNr: TestIdentifier): IsWord = ???

  //  case class IsWord(testNr: TestIdentifier) {
  //    def is[T] = ???
  //  }

  implicit class TestEnumeration(val testNr: TestIdentifier) {
    def test[T](assertion: => (T, T)) = {
      //      val (v1, v2) = assertion
      val v1 = assertion._1
      val v2 = assertion._2
      if (v1 == v2) {
        println(s"test $testNr was successful.")
      } else {
        println(s"test $testNr failed. $v1 did not equal $v2")
      }
    }
  }


}


