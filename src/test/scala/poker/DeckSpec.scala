package poker

import org.scalatest.{Matchers, WordSpec}
import poker.com.fun.poker.{Card, Deck}


class DeckSpec extends WordSpec with Matchers {

  " A deck" should {
    "return 52 unique cards" when {
      "its created" in {
        val deck = Deck
        val unique = deck.cards.toSet

        deck.cards.size shouldBe unique.size
        unique.size shouldBe 52
      }
    }

  }

}
