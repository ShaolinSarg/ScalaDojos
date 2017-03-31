package poker

import org.scalatest.{Matchers, WordSpec}
import poker.com.fun.poker.Deck

class DeckSpec extends WordSpec with Matchers {

  " A deck" should {
    "return 52 unique cards" when {
      "its created" in {
        val deck = Deck.createDeck
        val unique = deck.cards.toSet

        deck.size shouldBe unique.size
        unique.size shouldBe 52
      }
    }
    "allow the user to take a single card" in {
      val deck = Deck.createDeck
      val (card, remainingDeck) = deck.dealCard
      deck.cards should contain (card)
    }
    "contain one less card when a card is dealt" in {
      val deck = Deck.createDeck
      val (card, remainingDeck) = deck.dealCard
      deck.size - remainingDeck.size shouldBe 1
    }

    " less two cards in remaining cards when pick two cards" in {
      val deck = Deck.createDeck
      val (card, remainingDeck) = deck.dealCard
      val (secondCard, secondRemainingDeck)= remainingDeck.dealCard
      deck.size - secondRemainingDeck.size shouldBe 2

    }

  }

}
