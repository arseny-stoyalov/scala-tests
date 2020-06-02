import higherorder.HigherOrder._
import org.scalatest.{FunSuite, Matchers}

class HigherOrderTask extends FunSuite with Matchers {

  test("nTimes") {
    nTimes(_ + _, 5, 5, 2) shouldBe 20
  }

  test("anonNTimes") {
    nTimes((a: Int, b: Int) => a * b, 5, 2, 2) shouldBe 20
  }

}
