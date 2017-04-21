package poker.com.fun.poker

import poker.Hand

import scala.annotation.tailrec

case class Deck (cards : Set[Card]) {
  def dealHand: (Hand, Deck) = {

    @tailrec
    def rec(totalCards: Set[Card], deck: Deck): (Hand,Deck) ={
      totalCards.size match {
        case x if x < 5 =>
          val (card,remainingDeck) = deck.dealCard
          rec(totalCards + card, remainingDeck)
        case _ => (Hand(totalCards),deck)
      }
    }

    rec(Set(), this)
  }

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
