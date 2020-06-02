import org.scalatest.{FunSuite, Matchers}
import patterns.PatternMatching._

class PatternsTask extends FunSuite with Matchers {

  test("intToString") {
    intToString(1) shouldBe "it is one"
    intToString(4) shouldBe "what's that?"
  }

  test("isMaxOrMoritz") {
    val max = "Max"
    val moritz = "Moritz"
    isMaxOrMoritz(max) && isMaxOrMoritz(moritz)
      .&&(isMaxOrMoritz(max.toLowerCase)
        .&&(isMaxOrMoritz(moritz.toLowerCase))) shouldBe true
    isMaxOrMoritz("MAX") shouldBe false
  }

  test("isEven") {
    isEven(0) shouldBe true
    isEven(2) shouldBe true
    isEven(3) shouldBe false
  }

  test("rps") {
    rPS(Rock, Paper) shouldBe Lose
    rPS(Paper, Scissor) shouldBe Lose
    rPS(Scissor, Rock) shouldBe Lose
    rPS(Paper, Rock) shouldBe Win
    rPS(Paper, Paper) shouldBe Draw
  }

  test("extractMammalWeight") {
    val cat = Mammal("cat", Meat, 10)
    val parrot = Bird("parrot", Vegetables)
    extractMammalWeight(cat) shouldBe 10
    extractMammalWeight(parrot) shouldBe -1
  }

  test("updateFood") {
    val mammal = Mammal("mammal", Meat, 10)
    val bird = Bird("mammal", Vegetables)
    val fish = Fish("mammal", Meat)
    updateFood(bird).food shouldBe Plants
    updateFood(fish).food shouldBe Plants
    updateFood(mammal).food shouldBe mammal.food
  }


}
