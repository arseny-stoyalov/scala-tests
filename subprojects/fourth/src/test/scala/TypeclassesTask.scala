import org.scalatest.{FunSuite, Matchers}

import Typeclasses._

class TypeclassesTask extends FunSuite with Matchers{

  test("reverseString"){
    Reversable.reverse("string") shouldBe "string".reverse
  }

  test("smashes"){
    SmashInt.smash(3, 2) shouldBe 5
    SmashDouble.smash(3, 2) shouldBe 6
    SmashString.smash("3", "2") shouldBe "32"
  }

}
