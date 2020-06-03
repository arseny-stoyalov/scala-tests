import org.scalatest.{FunSuite, Matchers}

import Strings._

class StringsTask extends FunSuite with Matchers{

  test("uppercase"){
    testUppercase("lower case") shouldBe "LOWER CASE"
    testUppercase("Case") shouldBe "CASE"
  }

  test("interpolations"){
    testInterpolations("Michael", 20)
    .shouldBe("Hi my name is Michael and I am 20 years old.")
  }

  test("computation"){
    testComputation(6, 7)
    .shouldBe(s"""       Hi,
             now follows a quite hard calculation. We try to add:
               a := 6
               b := 7

               result is 13


      """)
  }

  test("takeTwo"){
    testTakeTwo("a") shouldBe "a"
    testTakeTwo("abcdefg") shouldBe "ab"
  }

}
