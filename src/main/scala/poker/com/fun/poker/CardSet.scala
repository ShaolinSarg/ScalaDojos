package poker


import poker.com.fun.poker._

import scala.annotation.tailrec


case class CardSet(cards: Set[Card]) {
  def getPairs: Set[Set[Card]] = {
    val x: Map[CardValue, Set[Card]] = {
      cards.groupBy(_.value)
    }
    x.filter(n => n._2.size == 2).values.toSet
  }

  def highCard = cards.fold(cards.head)(Card.highestCard)
}

object CardSet {
  def highHand(hand1: CardSet, hand2: CardSet) = {

    @tailrec
    def go(firstHand: CardSet, secondHand: CardSet): CardSet = {

      if (firstHand.cards.isEmpty){
        throw new IllegalArgumentException("")
      }
      else{
        val highestOne = firstHand.highCard
        val highestTwo = secondHand.highCard

        highestOne.compare(highestTwo) match {
          case 1 => hand1
          case -1 => hand2
          case 0 => go(CardSet(firstHand.cards - highestOne), CardSet(secondHand.cards - highestTwo))
        }
      }
    }
    go(hand1, hand2)

  }
}
