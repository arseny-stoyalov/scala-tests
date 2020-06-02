import scala.annotation.tailrec

/** Напишите свои решения в тестовых функциях.
 *
 * Seq(1, 2) match {
 * case head +: tail => ???
 * case Nil          => ???
 * case s            => ???
 * }
 *
 * https://www.scala-lang.org/api/2.12.0/scala/collection/Seq.html
 */
// Примечание: напишите функции с хвостовой рекурсией

object Sequence {

  /* a) Найдите последний элемент Seq.
   *
   */
  def testLastElement[A](seq: Seq[A]): Option[A] = Option(seq.last)

  /* b) Объедините две Seq (то есть Seq(1, 2) и Seq(3, 4) образуют Seq((1, 3), (2, 4)))
   *    - если Seq длиннее игнорируйте оставшиеся элементы.
   *    
   */

  def testZip[A](a: Seq[A], b: Seq[A]): Seq[(A, A)] = a zip b

  /* c) Проверьте, выполняется ли условие для всех элементов в Seq.
   *    
   */
  def testForAll[A](seq: Seq[A])(cond: A => Boolean): Boolean = seq.forall(cond)

  /* d) Проверьте, является ли Seq палиндромом
   *    
   */
  @tailrec
  def testPalindrom[A](seq: Seq[A]): Boolean = {
    if (seq.length < 2) return true
    if (seq.length == 2) seq.head == seq.last
    else seq.head == seq.last && testPalindrom(seq.drop(1).dropRight(1))
  }

  /* e) Реализуйте flatMap используя foldLeft.
   *    
   */
  def testFlatMap[A, B](seq: Seq[A])(f: A => Seq[B]): Seq[B] = {
    val res: Seq[B] = seq.foldLeft(f(seq.head))((m, n) => m ++ f(n))
    if (res.length > 2) res.drop(2)
    else res.drop(1)
  }
}
