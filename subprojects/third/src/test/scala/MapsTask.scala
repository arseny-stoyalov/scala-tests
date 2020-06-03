import org.scalatest.{FunSuite, Matchers}

import Maps._

class MapsTask extends FunSuite with Matchers {

  test("groupUsers"){
    val people = Seq(User("John", 15), User("John", 30)
      , User("John", 21), User("Tommy", 24), User("Olivia", 22))
    testGroupUsers(people) should contain theSameElementsAs
      List(("John", 22), ("Tommy", 24), ("Olivia", 22))
  }

  test("numberFrodos"){
    val adam = User("Adam", 26)
    val notAdam = User("Tom", 19)
    val users = Map(("1", adam), ("2", adam), ("3", adam), ("4", notAdam), ("5", notAdam))
    testNumberFrodos(users) shouldBe users.size - 2
  }

  test("underage"){
    val adult = User("Big", 49)
    val immature = User("smol", 13)
    val users = Map(("1", adult), ("2", adult), ("3", immature), ("4", adult))
    testUnderaged(users) should not contain immature
  }

}
