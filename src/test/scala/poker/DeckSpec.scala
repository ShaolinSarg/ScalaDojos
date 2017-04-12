package poker

import org.scalatest.{Matchers, WordSpec}
import poker.com.fun.poker.Deck

class DeckSpec extends WordSpec with Matchers {

  " A deck" should {
    "return 52 unique cards" when {
      "its created" in {
        val deck = Deck.createDeck
        deck.size shouldBe 52
      }
    }
    "allow the user to take a single card" in {
      val deck = Deck.createDeck
      val (card, _) = deck.dealCard
      deck.cards should contain (card)
    }
    "contain one less card when a card is dealt" in {
      val deck = Deck.createDeck
      val (_, remainingDeck) = deck.dealCard
      deck.size - remainingDeck.size shouldBe 1
    }

    "less two cards in remaining cards when pick two cards" in {
      val deck = Deck.createDeck
      val (_, remainingDeck) = deck.dealCard
      val (_, secondRemainingDeck)= remainingDeck.dealCard
      deck.size - secondRemainingDeck.size shouldBe 2
    }

    "deal a hand of 5 cards" in {
      val (hand, _) = Deck.createDeck.dealHand
      hand.cards.size shouldBe 5
    }

    "deck should have 47 remaining cards" in {
      val (_, remainingDeck) = Deck.createDeck.dealHand
      remainingDeck.size shouldBe 47
    }

    "deck should not contain cards already dealt" in {
      val (hand, remainingDeck) = Deck.createDeck.dealHand
      remainingDeck.cards should not contain (hand.cards)
    }


  }

}
