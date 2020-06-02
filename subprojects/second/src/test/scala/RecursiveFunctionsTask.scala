import org.scalatest.{FunSuite, Matchers}
import RecursiveFunctions._

class RecursiveFunctionsTask extends FunSuite with Matchers {

  val list: Cons[Int] = Cons(1, Cons(2, Cons(3, Cons(4, Nil()))))

  test("listLength") {
    listLength(list) shouldBe 4
  }

  test("reverse") {
    reverse(list) shouldBe Cons(4, Cons(3, Cons(2, Cons(1, Nil()))))
  }

  test("map") {
    map(list)(_.toString) shouldBe Cons("1", Cons("2", Cons("3", Cons("4", Nil()))))
  }

  test("appending") {
    append(list, Cons(5, Cons(6, Nil())))
      .shouldBe(Cons(1, Cons(2, Cons(3, Cons(4, Cons(5, Cons(6, Nil())))))))
  }

}
