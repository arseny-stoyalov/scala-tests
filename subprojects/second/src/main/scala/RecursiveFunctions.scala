import scala.annotation.tailrec

/** Реализуйте функции для решения следующих задач.
 * Примечание: Попытайтесь сделать все функции с хвостовой рекурсией, используйте аннотацию для подтверждения.
 * рекурсия будет хвостовой если:
 *   1. рекурсия реализуется в одном направлении
 *   2. вызов рекурсивной функции будет последней операцией перед возвратом
 */
object RecursiveFunctions {

  def listLength[A](as: List[A]): Int = {
    @tailrec
    def loop(rem: List[A], agg: Int): Int = rem match {
      case Cons(_, tail) => loop(tail, agg + 1)
      case Nil() => agg
    }

    loop(as, 0)
  }

  /* a) Напишите функцию которая записывает в обратном порядке список:
   *        def reverse[A](list: List[A]): List[A]
   */
  def reverse[A](list: List[A]): List[A] = {

    @tailrec
    def loop(list: List[A], res: List[A]): List[A] = list match {
      case Cons(head, tail) => loop(tail, Cons(head, res))
      case Nil() => res
    }

    loop(list, Nil())
  }

  // используйте функцию из пункта (a) здесь, не изменяйте сигнатуру
  def testReverse[A](list: List[A]): List[A] = reverse(list)

  /* b) Напишите функцию, которая применяет функцию к каждому значению списка:
   *        def map[A, B](list: List[A])(f: A => B): List[B]
   */
  def map[A, B](list: List[A])(f: A => B): List[B] = {

    @tailrec
    def loop(list: List[A], res: List[B]): List[B] = list match {
      case Cons(head, tail) => loop(tail, Cons(f(head), res))
      case Nil() => reverse(res)
    }

    loop(list, Nil())
  }

  // используйте функцию из пункта  (b) здесь, не изменяйте сигнатуру
  def testMap[A, B](list: List[A], f: A => B): List[B] = map(list)(f)

  /* c) Напишите функцию, которая присоединяет один список к другому:
   *        def append[A](l: List[A], r: List[A]): List[A]
   */
  def append[A](l: List[A], r: List[A]): List[A] = {

    @tailrec
    def loop(list: List[A], res: List[A]): List[A] = {
      list match {
        case Cons(head, tail) => loop(tail, Cons(head, res))
        case Nil() => res
      }
    }

    loop(reverse(l), r)
  }

  // используйте функцию из пункта  (c) здесь, не изменяйте сигнатуру
  def testAppend[A](l: List[A], r: List[A]): List[A] = append(l, r)

  /* d) Напишите функцию, которая применяет функцию к каждому значению списка:
   *        def flatMap[A, B](list: List[A])(f: A => List[B]): List[B]
   * 
   *    она получает функцию, которая создает новый List[B] для каждого элемента типа A в 
   *    списке. Поэтому вы создаете List[List[B]]. 
   */
  def flatMap[A, B](list: List[A])(f: A => List[B]): List[B] = {

    @tailrec
    def loop(list: List[A], res: List[List[B]]): List[B] = list match {
      case Cons(head, tail) => loop(tail, Cons(f(head), res))
      case Nil() => flatten(reverse(res), scala.Nil)
    }

    @tailrec
    def flatten(list: List[List[B]], result: scala.List[scala.List[B]]): List[B] = list match {
      case Cons(head, tail) => flatten(tail, parseList(head, scala.Nil) :: result)
      case Nil() => parseThisAbomination(result.flatten, 0)
    }

    def parseThisAbomination(list: scala.List[B], i: Int): List[B] = {
      if (i < list.length - 2) {
        Cons(list.head, parseThisAbomination(list.drop(i), i + 1))
      } else Cons(list.last, Nil())
    }

    def parseList(list: List[B], res: scala.List[B]): scala.List[B] = {
      list match {
        case Cons(head: B, tail: List[B]) => parseList(tail, head :: res)
        case Nil() => res
      }
    }

    loop(list, Nil())
  }

  // используйте функцию из пункта  (d) здесь, не изменяйте сигнатуру
  def testFlatMap[A, B](list: List[A], f: A => List[B]): List[B] = Nil()

  /* e) Вопрос: Возможно ли написать функцию с хвостовой рекурсией для `Tree`s? Если нет, почему? */
  /*
    Написать хвостовую рекурсию для дерева не представляется возможным, так как дерево ветвится, из-за чего
    пройтись перевого элемента к последнему не получится (при переходе в одну ветвь, значения другой станут
    недосягаемыми)
   */
}
