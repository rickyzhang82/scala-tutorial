def msort(xs: List[Int]): List[Int] = {
  val n = xs.length / 2
  if(0 == n) xs
  else{
    //demo pair
    def merge(xs: List[Int], ys: List[Int]): List[Int] =
      (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) => if (x < y) x :: merge(xs1, ys) else y :: merge(xs, ys1)
    }

    val (left, right) = xs splitAt n
    merge(msort(left), msort(right))
  }
}

val random_list = List(10, 9, 200, 24, 300, 3, 1, 9)
msort(random_list)


