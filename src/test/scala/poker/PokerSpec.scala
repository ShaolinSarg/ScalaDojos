package poker

import org.scalatest.{Matchers, WordSpec}
import poker.com.fun.poker._

class PokerSpec extends WordSpec with Matchers {

  "A card" should {
    "return its value" when {
      "given a valid card value" in {
        val myCard = Card(Four, Clubs)

        myCard.value shouldBe Four
      }
      "given a valid card value as Ace" in {
        val card = Card(Ace, Clubs)

        card.value shouldBe Ace
      }
    }

    "return the correct full suit name" when {
      "given the name of Clubs" in {
        val card = Card(Four, Clubs)
        card.suit shouldBe Clubs
      }
      "given the name of Hearts" in {
        val card = Card(Four, Hearts)
        card.suit shouldBe Hearts
      }
      "given the name of Spades" in {
        val card = Card(Five, Spades)
        card.suit shouldBe Spades
      }
      "given the short name of Diamonds" in {
        val card = Card(Two, Diamonds)
        card.suit shouldBe Diamonds
      }
    }

/*    "throw an exception" when {
      "Given a bad suit name" in {
        val exception = the[IllegalArgumentException] thrownBy Card(Three, "Z")
        exception.getMessage shouldBe "Invalid suit value"
      }

    }*/
  }
}
