//recursive sample: gcd
def gcd(a: Int, b:Int): Int =
  if (b==0) a
  else gcd(b, a%b)

//not recursive sample: factorial
 def factorial(n: Int): Int =
  if (n == 0) 1
  else n * factorial(n - 1)

//Note -- last action n * function call...
//Rewrite ->
def fact(n: Int): Int = {
     def tail_fact(n: Int, result: Int): Int =
       if (n == 1)
         result
       else
         tail_fact(n-1, n*result)
     tail_fact(n, 1)
}
