object Task3DNA extends App {

  def findComplementPair(nucleotide: Char): Option[Char] =
    nucleotide match {
      case 'A' => Some('T')
      case 'T' => Some('A')
      case 'C' => Some('G')
      case 'G' => Some('C')
      case _   => None
    }

  def buildComplementStrand(strand: String): Option[String] = {
    val complements = for {
      nucleotide <- strand
      complement <- findComplementPair(nucleotide)
    } yield complement

    if (complements.length == strand.length) Some(complements.mkString)
    else None
  }
  
  println(buildComplementStrand("ATCG"))
  println(buildComplementStrand("ATXG"))
}
