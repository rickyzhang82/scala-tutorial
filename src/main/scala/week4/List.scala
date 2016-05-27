package week4

import week3.{List, Cons, Nil}
/**
  * Created by rizhan on 5/24/16.
  */
//demo apply and function object. see list_function_object.sc
object List {
  def apply(): List[Int] = Nil
  def apply(x: Int): List[Int] = new Cons[Int](x, apply)
  def apply(x:Int, y:Int): List[Int] = new Cons[Int](x, apply(y))
}

