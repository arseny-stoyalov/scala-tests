sealed trait List[A]

case class Cons[A](head: A, tail: List[A]) extends List[A]

case class Nil[A]() extends List[A]

/** Напишите свои решения в виде функций. */
object RecursiveData {

  // a) Реализуйте функцию, определяющую является ли пустым `List[Int]`.
  def isListsEmpty[A](list: List[A]): Boolean = list.equals(Nil[A]())


  // используйте функцию из пункта (a) здесь, не изменяйте сигнатуру
  def testListIntEmpty(list: List[Int]): Boolean = isListsEmpty(list)

  // b) Реализуйте функцию, которая получает head `List[Int]`или возвращает -1 в случае если он пустой.

  def getHead(list: List[Int]): Int = {
    list match {
      case Cons(head, _) => head
      case _ => -1
    }
  }

  // используйте функцию из пункта (b) здесь, не изменяйте сигнатуру
  def testListIntHead(list: List[Int]): Int = getHead(list)

  // c) Можно ли изменить `List[A]` так чтобы гарантировать что он не является пустым?

  /** Можно
   * sealed trait List[A] {
   * val head: A
   * val tail: List[A]
   * }
   */

  /* d) Реализуйте универсальное дерево (Tree) которое хранит значения в виде листьев и состоит из:
   *      node - левое и правое дерево (Tree)
   *      leaf - переменная типа A
   */

}

/**
 * Tree
 */
sealed trait Tree[A] {

  val right: Tree[A]

  val left: Tree[A]

}

case class Node[A](value: A, l: Tree[A], r: Tree[A]) extends Tree[A] {
  override val left: Tree[A] = l
  override val right: Tree[A] = r
}

case class TreeNil[A]() extends Tree[A] {
  override val right: Tree[A] = null
  override val left: Tree[A] = null
}

