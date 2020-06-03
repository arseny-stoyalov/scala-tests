import org.scalatest.{FunSuite, Matchers}
import Adts._

import scala.util.{Failure, Success}

class AdtsTask extends FunSuite with Matchers {

  test("getAt") {
    val list = List(3, 1, 1, 1, 2, 3, 5)
    getAt(list, 4) shouldBe Some(2)
  }

  test("double") {
    double(Option(3)) shouldBe Some(6)
    double(None) shouldBe None
  }

  test("isEven") {
    isEven(6) shouldBe Right(6)
    isEven(3) shouldBe Left("Нечетное число.")
  }

  test("safeDivide") {
    safeDivide(5, 1) shouldBe Right(5)
    safeDivide(5, 0) shouldBe a[Left[String, Int]]
  }

  test("goodOldJava") {
    val parse: String => Int =
      (str: String) => Integer.valueOf(str)
    goodOldJava(parse, "5") shouldBe a [Success[Int]]
    goodOldJava(parse, "failure") shouldBe a [Failure[Int]]

  }

}
