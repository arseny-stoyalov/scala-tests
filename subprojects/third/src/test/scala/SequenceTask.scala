import org.scalatest.{FunSuite, Matchers}

import Sequence._

class SequenceTask extends FunSuite with Matchers {

  test("lastElement") {
    val seq = Seq(1, 2, 3, 4, 5)
    testLastElement(seq) shouldBe Some(5)
    testLastElement(Seq()) shouldBe None
  }

  test("zip") {
    testZip(Seq(1, 2, 3), Seq(5, 4, 3)) should contain theSameElementsAs Seq((1, 5), (2, 4))
  }

  test("forAll") {
    val condition = (str: String) => str.length < 5
    testForAll(Seq("one", "two", "five", "four"))(condition) shouldBe true
    testForAll(Seq("one", "two", "five", "three"))(condition) shouldBe false
  }

  test("palindrome") {
    testPalindrom(Seq(1, 2, 3, 2, 1)) shouldBe true
    testPalindrom(Seq(1, 2, 3, 2, 2)) shouldBe false
    testPalindrom(Seq(1)) shouldBe true
    testPalindrom(Seq()) shouldBe true
  }

  test("flatMap") {
    val seq = Seq(Seq(1, 2, 3), Seq(4, 5, 6))
    testFlatMap(seq)(_.map(_ * 2)) shouldBe seq.flatMap(_.map(_ * 2))
  }

}
