package poker.com.fun.poker


object Deck {

  val cards: List[Card] = createDeck

  private def createDeck : List[Card] = {

    val nums = List(Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King)
    val suits = List(Clubs, Spades, Hearts, Diamonds)

    for {
      num <- nums
      suit <- suits
    } yield Card(num, suit)

  }
}
