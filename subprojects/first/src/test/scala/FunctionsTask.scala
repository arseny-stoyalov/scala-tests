import functions.Functions
import org.scalatest.{FunSuite, Matchers}

class FunctionsTask extends FunSuite with Matchers {

  test("circleArea") {
    for (r <- 1 to 10)
      Functions.circleArea(r) shouldBe (r * r * Math.PI) +- 0.1
  }

  test("rectAreaCurried") {
    for(side <- 1 to 10)
      Functions.rectAreaCurried(side)(side) shouldBe(side * side)
  }

  test("rectArea") {
    for(side <- 1 to 10)
      Functions.rectArea(side, side + 2) shouldBe(side * (side + 2))
  }

}
