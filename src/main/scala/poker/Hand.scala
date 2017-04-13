package poker

import poker.com.fun.poker._

/**
  * Created by davidsarginson on 06/04/2017.
  */
case class Hand (cards: Set[Card]) {
  def highCard = {
    if (cards.contains(Card(Ace, Hearts)))
     Card(Ace, Hearts)
    else if (cards.contains(Card(Ace, Spades)))
      Card(Ace, Spades)
    else
      Card(King, Diamonds)

  }
}
