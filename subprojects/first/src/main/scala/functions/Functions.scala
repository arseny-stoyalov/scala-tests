package functions

/** Напишите отдельные функции, решающие поставленную задачу.
 *
 * Синтаксис:
 * // метод
 * def myFunction(param0: Int, param1: String): Double = // тело
 *
 * // значение
 * val myFunction: (Int, String) => Double (param0, param1) => // тело
 */
object Functions {

  /* a) Напишите функцию, которая рассчитывает площадь окружности
   *    r^2 * Math.PI
   */
  def circleArea(r: Double): Double = Math.pow(r, 2) * Math.PI

  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testCircle(r: Double): Double = circleArea(r)


  /* b) Напишите карированную функцию которая рассчитывает площадь прямоугольника a * b.
   */
  def rectAreaCurried(a: Double)(b: Double): Double = a * b

  // примените вашу функцию из пукта (b) здесь, не изменяя сигнатуру
  def testRectangleCurried(a: Double, b: Double): Double = rectAreaCurried(a)(b)


  // c) Напишите не карированную функцию для расчета площади прямоугольника.
  def rectArea(a: Double, b: Double): Double = a * b

  // примените вашу функцию из пункта (c) здесь, не изменяя сигнатуру
  def testRectangleUc(a: Double, b: Double): Double = rectArea(a, b)

}
