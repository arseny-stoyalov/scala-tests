import classes.animals.Animal
import patterns.PatternMatching
import patterns.PatternMatching.{Rock, Scissor}

object Main extends App {

  val animal = Animal.apply("parrot")
  println(animal.get)
  println(PatternMatching.isMaxOrMoritz("moritz"))
  println(PatternMatching.rPS(Rock, Scissor))
  println(PatternMatching.updateFood(PatternMatching.Bird("eagle", PatternMatching.Meat)))

}
