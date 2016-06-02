val fruit: List[String] = List("apples", "oranges", "pears")
val veg: List[String] = List("cabbage", "carrot")

val nums : List[Int] = List(1, 2, 3, 4)

val diag3: List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))

val empty: List[Int] = List()

def last[T](xs: List[T]): T = xs match {
  case List() => throw new Error("last of empty list!")
  case List(x) => x
  case y :: ys => last(ys)
}

last(fruit)
last(nums)
last(diag3)
//last(empty)

def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
  case List() => ys
  case z :: zs => z :: concat(zs, ys)
}

concat(fruit, veg)

def reverse[T](xs: List[T]): List[T] = xs match {
  case List() => xs
  case z :: zs => reverse(zs) ++ List(z)
}

reverse(diag3)

def removeAt[T](xs: List[T], n: Int): List[T] = xs match {
  case List() => xs
  case z :: zs => if (0 == n) zs else z :: removeAt(zs, n - 1)
}

removeAt(fruit, 0)
removeAt(fruit, 1)
removeAt(fruit, 2)
removeAt(fruit, 3)
removeAt(fruit, 4)



