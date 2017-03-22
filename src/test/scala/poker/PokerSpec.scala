package poker

import org.scalatest.{Matchers, WordSpec}
import poker.com.fun.poker.Card

class PokerSpec extends WordSpec with Matchers {

  "A card" should {
    "return its value" when {
      "given a valid card value" in {
        val myCard = Card("4", "C")

        myCard.value shouldBe "4"
      }
      "given a valid card value as A" in {
        val card = Card("A", "C")

        card.value shouldBe "A"
      }
    }

    "return the correct full suite name" when {
      "given the short name of C" in {
        val card = Card("4", "C")
        card.suite shouldBe "Club"
      }
      "given the short name of H" in {
        val card = Card("4", "H")
        card.suite shouldBe "Hearts"
      }
      "given the short name of S" in {
        val card = Card("5", "S")
        card.suite shouldBe "Spades"
      }
      "given the short name of D" in {
        val card = Card("2", "D")
        card.suite shouldBe "Diamonds"
      }
    }

    "throw an exception" when {
      "Given a bad suit short name" in {
        val exception = the[IllegalArgumentException] thrownBy Card("3", "Z")
        exception.getMessage shouldBe "Invalid suit value"
      }
      "Given a wrong card value" in {
        val exception = the[IllegalArgumentException] thrownBy Card("1", "H")
        exception.getMessage shouldBe "Invalid card value"
      }
      "Given a wrong card value as 11" in {
        val exception = the[IllegalArgumentException] thrownBy Card("11", "H")
        exception.getMessage shouldBe "Invalid card value"
      }

    }
  }
}
