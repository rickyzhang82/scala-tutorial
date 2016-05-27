import week4.{Number, Sum, Prod, Var}

Sum(Number(2), Prod(Number(1), Number(5))) eval

Sum(Number(2), Prod(Number(1), Number(5))) show

Prod(Number(2), Sum(Number(1), Number(5))) eval

Prod(Number(2), Sum(Number(1), Number(5))) show

Prod(Sum(Number(1), Number(5)), Number(2)) show

Prod(Sum(Number(1), Number(5)), Number(2)) eval

Prod(Sum(Number(1), Number(5)), Sum(Number(2), Number(4))) show

Prod(Sum(Number(1), Number(5)), Sum(Number(2), Number(4))) eval

Prod(Sum(Var("x"), Number(5)), Sum(Number(2), Number(4))) show

Prod(Sum(Var("x"), Number(5)), Sum(Number(2), Number(4))) eval
