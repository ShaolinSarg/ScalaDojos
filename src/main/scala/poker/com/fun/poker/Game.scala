package poker.com.fun.poker

import poker.CardSet

import scala.collection.immutable.Stream.Empty

case class Game(hands: Map[Int, CardSet]) {
  def winner = {
    val playerOneCards: CardSet = hands(1)
    val playerTwoCards = hands(2)
    val playerOnePairs: Set[Set[Card]] = playerOneCards.getPairs
    val playerTwoPairs: Set[Set[Card]] = playerTwoCards.getPairs

    (playerOnePairs.isEmpty, playerTwoPairs.isEmpty) match {
      case (true, true) =>
        if (playerOneCards == CardSet.highHand(playerOneCards, playerTwoCards)) {
          Player(1)
        } else
          Player(2)

      case (playerOneHasPair, true) => Player(1)
      case (true, playerTwoHasPair) => Player(2)
      case (playerOneHasPair, playerTwoHasPair) =>

        if (playerOnePairs.size > playerTwoPairs.size) Player(1)
        else if (playerOnePairs.size < playerTwoPairs.size) Player(2)
        else {
          if (playerOneCards == CardSet.highHand(CardSet(playerOnePairs.head), CardSet(playerTwoPairs.head))) {
            Player(1)
          } else
            Player(2)
        }
    }
  }
}

object Game {
  def start(i: Int): Game = {

    val (cardSet1, remainingCards) = Deck.createDeck.dealHand
    val (cardSet2, _) = remainingCards.dealHand
    Game(Map(1 -> cardSet1,
      2 -> cardSet2))
  }

}
