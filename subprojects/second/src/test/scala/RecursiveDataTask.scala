import org.scalatest.{FunSuite, Matchers}
import RecursiveData._

class RecursiveDataTask extends FunSuite with Matchers {

  test("isListEmpty") {
    isListsEmpty(Nil()) shouldBe true
  }

  test("getHead") {
    getHead(Nil()) shouldBe -1
    getHead(Cons(1, Cons(2, Cons(3, Nil())))) shouldBe 1
  }

  test("tree") {
    val tree =
      Node(1, Node(2, Node(3, TreeNil(), TreeNil()), Node(4, TreeNil(), TreeNil())), TreeNil())
    tree.l.equals(TreeNil()) shouldBe false
  }

}
