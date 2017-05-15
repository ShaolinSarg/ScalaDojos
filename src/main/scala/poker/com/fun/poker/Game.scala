package poker.com.fun.poker

import poker.CardSet

case class Game(hands: Map[Int, CardSet]) {
  def winner = {
    val playerOneCards = hands(1)
    val playerTwoCards = hands(2)

    if (playerOneCards == CardSet.highHand(playerOneCards, playerTwoCards)){
      Player(1)
    }else
      Player(2)

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
