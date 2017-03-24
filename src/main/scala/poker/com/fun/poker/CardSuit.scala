package poker.com.fun.poker


sealed trait CardSuit

case object Clubs extends CardSuit
case object Spades extends CardSuit
case object Hearts extends CardSuit
case object Diamonds extends CardSuit

