package week4

/**
  * Created by rizhan on 5/24/16.
  */
//Why covariant? See object test
trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  //Note:
  // def prepend(elem: T): List[T] = new Cons[T](elem, this)
  // show error -- covariant type T is in contra-variant position. ie T as function argument
  //  Suppose Empty :< IntSet, NonEmpty :< IntSet
  //  If xs: List[IntSet],xs prepend Empty is fine.
  //  If ys: List[NonEmpty], ys prepend Empty is type error
  // Solution:
  //  covariant type parameter T may appear in lower bounds of method type parameters
  //  contra-variant type parameter may appear in upper bounds of method
  def prepend[U >: T](elem: U): List[U] = new Cons[U](elem, this)
  override def toString = if (isEmpty) " ." else head + ", " + tail
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

//Note: type Nothing is sub type of all types
//object is static. It can't be parameterized type
//It extend List[Nothing]. Nothing is sub type of every type
object Nil extends List[Nothing] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

//demo apply and function object. see list_function_object.sc
object List {
  def apply(): List[Int] = Nil
  def apply(x: Int): List[Int] = new Cons[Int](x, apply)
  def apply(x:Int, y:Int): List[Int] = new Cons[Int](x, apply(y))
}

object test {
  //Nothing <: String
  //To make List[Nothing] <: List[String] ( so that Nil is sub type of List[String]
  //declare covariant in List[+T]
  val x: List[String] = Nil
 // def f(xs: List[NonEmpty], x: Empty) = xs prepend x
}