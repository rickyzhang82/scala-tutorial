package demo

import org.scalatest.FunSuite

/**
  * Created by rizhan on 5/19/16.
  */
class HelloTest extends FunSuite {
  test("sayHello methods works correctly"){
    val hello = new Hello
    assert(hello.sayHello("Scala") == "Hello, Scala!")
  }
}
