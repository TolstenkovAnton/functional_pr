object Task2Validation extends App {

  def validateUserInput(input: String): Option[Int] =
    try {
      val number = input.toInt
      if (number > 0) Some(number) else None
    } catch {
      case _: NumberFormatException => None
    }

  def processInput(validatedInput: Option[Int]): String =
    validatedInput match {
      case Some(value) => s"Вы ввели число: $value"
      case None => "Некорректный ввод. Пожалуйста, введите положительное число."
    }
  
  println(processInput(validateUserInput("42")))
  println(processInput(validateUserInput("-5")))
  println(processInput(validateUserInput("abc")))
}
