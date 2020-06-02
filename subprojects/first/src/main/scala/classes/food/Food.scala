package classes.food

import classes.food.entities.{Meat, Plants, Vegetables}

/**
 * Simple food entity
 */
trait Food {

  val name: String

}

object Food {

  val meat: Meat = Meat("meat")
  val vegetables: Vegetables = Vegetables("vegetables")
  val plants: Plants = Plants("plants")

  def apply(name: String): Option[Food] =
    name match {
      case "meat" => Some(Food.meat)
      case "vegetables" => Some(Food.vegetables)
      case "plants" => Some(Food.plants)
      case _ => None
    }

}



