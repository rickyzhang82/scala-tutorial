//convert sum into product
def product(f: Int => Int)(a: Int, b: Int): Int = {

  def loop(a: Int, acc: Int): Int = {
    if (a > b)
      acc
    else
      loop(a + 1, f(a) * acc)
  }

  loop(a, 1)
}

// use it to build factorial
def factorial(x: Int): Int = product(x => x)(1, x)

factorial(5)

//combine sum and product
def mapReduce(f: Int => Int,
              combine: (Int, Int) => Int,
              identity: Int)
                (a: Int, b: Int): Int ={

  def loop(a: Int, acc: Int): Int = {
    if (a > b)
      acc
    else
      loop(a + 1, combine(f(a), acc))
  }

  loop(a, identity)
}

def fact_mapReduce(x: Int): Int =
  mapReduce(x => x, (a, b) => a*b, 1) (1, x)

fact_mapReduce(5)


