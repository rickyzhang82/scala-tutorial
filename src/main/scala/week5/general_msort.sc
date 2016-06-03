import math.Ordering

//demo implicit type
def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
  val n = xs.length / 2
  if(0 == n) xs
  else{
    //demo pair
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) => if (ord.lt(x, y)) x :: merge(xs1, ys) else y :: merge(xs, ys1)
    }

    val (left, right) = xs splitAt n
    merge(msort(left), msort(right))
  }
}

val int_list = List(10, 9, 200, 24, 300, 3, 1, 9)
val fruits = List("strawberry", "apples", "oranges", "pears")

msort(int_list)
msort(fruits)