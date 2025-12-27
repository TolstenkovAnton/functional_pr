case class Book(
  title: String,
  author: String,
  year: Int,
  rating: Double
)

object Task1Books extends App {

  val library = List(
    Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, 4.95),
    Book("The Hobbit", "J.R.R. Tolkien", 1937, 4.8),
    Book("1984", "George Orwell", 1949, 4.7),
    Book("Scala in Depth", "Joshua Suereth", 2012, 4.4),
    Book("Programming in Scala", "Martin Odersky", 2008, 4.9),
    Book("The Martian", "Andy Weir", 2014, 4.6)
  )

  val booksAfter2000 = library.filter(_.year > 2000)
  println("Книги после 2000 года:")
  println(booksAfter2000)

  val tolkienTitles = library
    .filter(_.author == "J.R.R. Tolkien")
    .map(_.title)

  println("\nКниги Толкина:")
  println(tolkienTitles)

  val top3Books = library
    .sortBy(_.rating)(Ordering[Double].reverse)
    .take(3)

  println("\nТоп-3 книги по рейтингу:")
  println(top3Books)

  val averageRating = library.map(_.rating).sum / library.size
  println("\nСредний рейтинг:")
  println(averageRating)
}
