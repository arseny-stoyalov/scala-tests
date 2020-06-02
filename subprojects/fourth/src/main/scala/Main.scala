import Typeclasses._

object Main {
  def main(args: Array[String]): Unit = {
    println(testReversableString("henlo"))
    println(testSmashDouble(5, 5))
    println(testSmashInt(5, 5))
    println(testSmashString("5", "5"))
  }
}