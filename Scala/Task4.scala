// ======================
// Задание 4. Простой JSON-сериализатор
// ======================

trait JsonWritable {
  def toJson: String
}

object JsonWritable {

  def toJson(value: Any): String = value match {
    
    case s: String =>
      "\"" + s + "\""
      
    case i: Int =>
      i.toString

    case d: Double =>
      d.toString
      
    case b: Boolean =>
      b.toString
      
    case jw: JsonWritable =>
      jw.toJson
      
    case _ =>
      "{}"
  }
}

case class User(name: String, age: Int) extends JsonWritable {
  override def toJson: String =
    s"""{"name": "${name}", "age": ${age}}"""
}

object Task4JsonSerializer extends App {

  println(JsonWritable.toJson("hello"))
  println(JsonWritable.toJson(42))
  println(JsonWritable.toJson(3.14))
  println(JsonWritable.toJson(true))

  val user = User("Alice", 30)
  println(JsonWritable.toJson(user))

  println(JsonWritable.toJson(List(1, 2)))
}
