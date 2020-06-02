import java.util.NoSuchElementException

import classes.animals.Animal
import classes.food.Food
import org.scalatest.{FunSuite, Matchers}

class ClassesTask extends FunSuite with Matchers {

  test("food instancing") {
    Food("Invalid") shouldBe None
    Food("meat") shouldBe a[Some[_]]
  }

  test("animal instancing") {
    val valid = Animal("parrot")
    val invalid = Animal("dog")
    valid shouldBe a[Some[_]]
    invalid shouldBe None
    Animal.knownAnimal(valid.get) shouldBe true
  }

  test("eating") {
    val animal = Animal("cat").get
    animal.eats(Food.meat) shouldBe true
    animal.eats(Food.vegetables) shouldBe false
    a[NoSuchElementException] shouldBe thrownBy(animal.eats(Food("Invalid").get))
  }

}
