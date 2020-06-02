package classes.animals

import classes.animals.entities.{Bird, Fish, Mammal}
import classes.food.Food

/**
 * A simple animal entity
 */
trait Animal {

  val name: String

  val food: Food

  /**
   * Returns if animal eats certain food
   *
   * @param food food that animal may or may not eat
   * @return true if animal eats the food, false otherwise
   */
  def eats(food: Food): Boolean =
    ((name equals Animal.cat.name) && (food equals Animal.cat.food)) ||
      ((name equals Animal.parrot.name) && (food equals Animal.parrot.food)) ||
      ((name equals Animal.goldfish.name) && (food equals Animal.goldfish.food))

}

object Animal {

  val cat: Mammal = Mammal("cat", Food.meat)
  val parrot: Bird = Bird("parrot", Food.vegetables)
  val goldfish: Fish = Fish("goldfish", Food.plants)

  /**
   * Checks if animal is valid
   * @param animal animal to check
   * @return true if valid, false otherwise
   */
  def knownAnimal(animal: Animal): Boolean =
    animal.isInstanceOf[Mammal] || animal.isInstanceOf[Bird] || animal.isInstanceOf[Fish]

  def apply(name: String): Option[Animal] =
    name match {
      case "cat" => Some(Animal.cat)
      case "parrot" => Some(Animal.parrot)
      case "goldfish" => Some(Animal.goldfish)
      case _ => None
    }
}