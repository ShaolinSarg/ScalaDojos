package poker.com.fun.poker

case class Card(value: CardValue, suit: CardSuit) {

  def compare(that: Card) = this.value.value.compareTo(that.value.value)

}

object Card {
  def highestCard(card1: Card, card2: Card) = if (card1.compare(card2) == 1) card1 else card2
}