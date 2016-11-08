PLDA - week 7
===============================================================================

This week we did a crash course in [Scala](http://scala-lang.org/) to prepare for next week where we'll be looking at all sorts of ways of handling concurrency.
 
To introduce basic concepts we build a mini dsl that allows us to express tests. You can find the source files in the [scala-test-dsl](./scala-test-dsl) folder.
I recommend that you use the [IntelliJ IDE](https://www.jetbrains.com/idea/#chooseYourEdition) with the scala plugin (when first starting intellij you have an option to install some of the most popular plugins, and the Scala plugin is one of them (at least it was several months ago (you can see that I have written too much LISP, and I don't mind all the parentheses))), and [import it as an sbt project](https://www.jetbrains.com/help/idea/2016.2 getting-started-with-sbt.html#import_project).

Basic summary of scala concepts that we talked about:
 - [syntax cheat sheet ](http://docs.scala-lang.org/cheatsheets/)
 - [syntax for method invocation](http://docs.scala-lang.org/style/method-invocation.html)
 - [implicit classes](http://docs.scala-lang.org/overviews/core/implicit-classes.html)
 - [traits](http://docs.scala-lang.org/tutorials/tour/traits.html)
 - [case classes](http://docs.scala-lang.org/tutorials/tour/case-classes.html)
 - [singleton objects](http://docs.scala-lang.org/tutorials/tour/singleton-objects.html)
 - [DSLs in scala](http://www.scala-lang.org/old/node/1403)

 
Basic summary of what we forgot to talk about:
 - [implicit conversions](http://docs.scala-lang.org/tutorials/tour/implicit-conversions)
 - [type classes](http://typelevel.org/cats/typeclasses.html). This is as they are abstracted in the library `cats`, so that it's more similar to Haskell.
