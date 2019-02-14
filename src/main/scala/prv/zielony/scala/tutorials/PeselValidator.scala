package prv.zielony.scala.tutorials

/**
  * Created by zielony on 02.02.16.
  */
object PeselValidator {

  /**
    * The aim is to validate the PESEL number, which is more or less a Polish ID number.
    * The validation should go as follows:
    * 1. The number has to have 11 digits
    * 2. The following algorithm should hold:
    *
    * We multiply multiply digits respectively:
    *   - first by 1
    *   - second by 3
    *   - third by 7
    *   - fourth by 9
    *   - fifth by 1
    *   - sixth by 3
    *   - seventh by 7
    *   - eight by 9
    *   - ninth by 1
    *   - tenth by 3
    *   - eleventh by 1
    * where the first digit is the one on the left-hand side as the number is written, i.e. for
    * 1234 the first digit is 1 and the fourth is 4.
    * Next, we sum all the results. If the final result is divisible by 10, the PESEL number is correct.
    * Otherwise, it isn't.
    */

  def validate(pesel: Long): Boolean = {
    println(pesel.toString.length)
    println(pesel.toString)
    if (pesel.toString.length != 10)
      return false
    else {
      val peselDigitsList: List[Int] = pesel.toString.map(_.asDigit).toList
      val checkSum: Int = (peselDigitsList.head +
        3 * peselDigitsList(1) +
        7 * peselDigitsList(2) +
        9 * peselDigitsList(3) +
        peselDigitsList(4) +
        3 * peselDigitsList(5) +
        7 * peselDigitsList(6) +
        9 * peselDigitsList(7) +
        peselDigitsList(8) +
        3 * peselDigitsList(9) +
        peselDigitsList(10))%10
      println(checkSum)
      println(peselDigitsList(10))
      if (checkSum == peselDigitsList(10))
        true
      else
        false
    }
  }
}
