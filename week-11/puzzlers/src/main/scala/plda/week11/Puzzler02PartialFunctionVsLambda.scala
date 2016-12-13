package plda.week11

/**
  *
  * @author Lorand Szakacs, lorand.szakacs@busymachines.com, lsz@lorandszakacs.com
  * @since 06 Dec 2016
  *
  *        http://scalapuzzlers.com/#pzzlr-022
  */
object Puzzler02PartialFunctionVsLambda extends App {

  def puzzler(): Unit = {
    var x = 0

    def counter: Int = {
      x += 1
      x
    }

    def add(a: Int)(b: Int) = a + b

    val adder1 = add(counter)(_)
    val adder2 = add(counter) _

    println("x = " + x)
    println(s"adder1 = ${adder1(10)}")
    println("x = " + x)
    println(s"adder2 = ${adder2(10)}")
    println("x = " + x)
  }

  puzzler()

}
