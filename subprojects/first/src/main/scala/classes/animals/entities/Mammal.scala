package classes.animals.entities

import classes.animals.Animal
import classes.food.Food

case class Mammal(name: String, food: Food) extends Animal

