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

def pack(xs: List[Int]): List[List[Int]] = xs match {
  case Nil => Nil
    //TODO fix me
  case y :: ys => pack(ys)
}
