package poker


import org.scalatest.{Matchers, WordSpec}
import poker.com.fun.poker._


class CardSpec extends WordSpec with Matchers {

  "highestCard" should {
    "return the highest card" when {
      "given cards with different values" in {
        val card1 = Card(Ace, Spades)
        val card2 = Card(Queen, Hearts)

        Card.highestCard(card1, card2) shouldBe card1
        
      }
    }


  }

  " A card" should {
    "indicate the higher card" when {
      "two different value cards are compared" in {

        val card1 = Card(Ace, Spades)
        val card2 = Card(Queen, Hearts)

        card1.compare(card2) shouldBe 1

        Card(Three, Hearts).compare(Card(Two, Clubs)) shouldBe 1

      }
    }
    "indicate the lower card" when {

      "two different value cards are compared" in {

        val card1 = Card(Two, Spades)
        val card2 = Card(Three, Hearts)

        card1.compare(card2) shouldBe -1
      }
    }
    "indicate the equal value card" when {

      "two of the same value cards are compared" in {

        val card1 = Card(Two, Spades)
        val card2 = Card(Two, Hearts)

        card1.compare(card2) shouldBe 0

      }
    }
  }
}
