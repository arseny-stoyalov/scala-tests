import org.scalatest.{FunSuite, Matchers}
import Compositions._

class CompositionsTask extends FunSuite with Matchers {

  test("compose") {
    val f: Int => String = Integer.toString(_, 16)
    val g: String => Double = _.length
    val h: Double => Char = _.toChar
    val t = testCompose(f)(g)(h)
    t(5) shouldBe 1
  }

}
