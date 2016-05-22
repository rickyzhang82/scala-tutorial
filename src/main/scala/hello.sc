import demo.Hello

val hello = new Hello

println(hello.sayHello("world"))

// y pass by name
def and_pbn(x: Boolean, y: => Boolean) = if (!x) false else y

// y pass by value
def and_pbv(x: Boolean, y: Boolean) = if (!x) false else y

def loop : Boolean = loop

and_pbn(false, loop)
//return false

// pass by value, loop
//and_pbv(false, loop)










