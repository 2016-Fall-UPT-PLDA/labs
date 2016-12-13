# Futures as Monads


In this week you saw that the concept of a `Future` can be modeled as a monad, please refer to previous weeks to recap Monads. All foundational concepts on how to use futures in scala can be read from the [official documentation](http://docs.scala-lang.org/overviews/core/futures.html).

### Actors vs. Futures

The basic design principle that one ought to use when deciding wether or not to use actors or monads should be the following: if you want to protect access to state, use Actors, otherwise use Futures. Please refer to [this](https://www.chrisstucchio.com/blog/2013/actors_vs_futures.html) rather good discussion on the topic.

