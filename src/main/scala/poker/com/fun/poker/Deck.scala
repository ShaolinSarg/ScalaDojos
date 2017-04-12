package poker.com.fun.poker

import poker.Hand

case class Deck (cards : Set[Card]) {
  def dealHand: (Hand, Deck) = (Hand(cards.take(5)), Deck(cards.drop(5)))

  val size = cards.size

  def dealCard :(Card, Deck) = {

    (cards.head, Deck(cards.tail))

  }

}

object Deck {

  def createDeck : Deck = {

    val nums = Set(Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King)
    val suits = Set(Clubs, Spades, Hearts, Diamonds)

    Deck ( for {
      num <- nums
      suit <- suits
    } yield Card(num, suit)
    )
  }

}
