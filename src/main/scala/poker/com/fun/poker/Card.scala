package poker.com.fun.poker

case class Card(value: CardValue, suit: CardSuit) {

  def compare(that: Card) = this.value.value.compareTo(that.value.value)


}
