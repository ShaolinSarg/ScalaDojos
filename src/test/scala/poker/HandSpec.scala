package poker


import org.scalatest.{Matchers, WordSpec}
import poker.com.fun.poker._


class HandSpec extends WordSpec with Matchers{

  "Hand" should {
    "return the high card" in {
      val hand = Hand(Set(Card(Two, Spades), Card(Ace, Hearts)))

      hand.highCard shouldBe Card(Ace, Hearts)
    }

    "return the high card when passed 3 cards" in {
      val hand = Hand(Set(Card(Two, Spades), Card(Three, Spades), Card(King, Diamonds)))

      hand.highCard shouldBe Card(King, Diamonds)
    }

    "return the high card when passed 3 face cards" in {
      val hand = Hand(Set(Card(Ace, Spades), Card(Queen, Hearts), Card(King, Diamonds)))

      hand.highCard shouldBe Card(Ace, Spades)
    }
  }

}
