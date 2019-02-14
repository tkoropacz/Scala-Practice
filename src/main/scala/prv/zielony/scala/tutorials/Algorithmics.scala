package prv.zielony.scala.tutorials

/**
  * Created by zielony on 01.02.16.
  */
object Algorithmics {

  /**
    * The goal of the first exercise is to implement the factorial function defined as:
    *    - for negative numbers (None)
    *    - for zero: 1
    *    - for positive numbers: factorial(n) = n * factorial(n-1)
    */

  def factorial(input: Int): Option[Int] = {
    if (input == 0)
      return Option(1)
    if (input < 0)
      return None
    else
      return factorial(input - 1).map(_ * input)
  }

  /**
    * The goal is to implement a function calculating Fibonacci numbers, defined as:
    *  - for negative numbers: undefined (None)
    *  - for zero: 1
    *  - for one: 2
    *  - for positive numbers: f(n) = f(n-1) + f(n-2)
    */

  def fibonacci(n: Int): Option[Int] = {
    if (n < 0 )
      return None
    if (n == 0)
      return Option(1)
    if (n == 1)
      return Option(2)
    else
      return fibonacci(n-1).map(_ + fibonacci(n-2).getOrElse(0))
  }
}
