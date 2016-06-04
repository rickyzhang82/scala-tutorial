def squareList(xs: List[Int]): List[Int] = {
  xs map (x => x * x)
}

val int_list = List(10, 9, -200, 24, 10, -3, 1, 9)
squareList(int_list)

val condition:(Int => Boolean) = {x => x > 0}

int_list filter condition
int_list filterNot condition
int_list partition condition
int_list takeWhile condition
int_list dropWhile condition
int_list span condition

//pack consecutive equal element into sub list
def pack[T](xs: List[T])(implicit ord: Ordering[T]): List[List[T]] =
  xs match {
    case Nil => Nil
    case x :: xs1 => xs.takeWhile(ord.equiv(_, x)) :: pack(xs.dropWhile(ord.equiv(_,x)))
  }


val str_list = List("a", "a", "a", "b", "b", "c", "a")
pack(str_list)

def encode[T](xs: List[T])(implicit ord: Ordering[T]): List[Tuple2[T, Int]] = {
  val pack_list = pack(xs)
  def count(ps: List[List[T]]): List[Tuple2[T, Int]] =
    ps match {
      case Nil => Nil
      case p1 :: ps1 => Tuple2(p1 head, p1.length) :: count(ps1)
  }
  count(pack_list)
}

encode(str_list)


