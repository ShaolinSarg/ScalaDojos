package poker.com.fun.poker

case class Deck (cards : List[Card]) {

  val size = cards.size

  def dealCard :(Card, Deck) = {

    (cards.head, Deck(cards.tail))

  }

}

object Deck {

  def createDeck : Deck = {

    val nums = List(Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King)
    val suits = List(Clubs, Spades, Hearts, Diamonds)

    Deck ( for {
      num <- nums
      suit <- suits
    } yield Card(num, suit)
    )
  }

}
