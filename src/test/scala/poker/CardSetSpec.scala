package poker


import org.scalatest.{Matchers, WordSpec}
import poker.com.fun.poker._


class CardSetSpec extends WordSpec with Matchers{

  "CardSet" should {
    "return the high card" in {
      val hand = CardSet(Set(Card(Two, Spades), Card(Ace, Hearts)))

      hand.highCard shouldBe Card(Ace, Hearts)
    }

    "return the high card when passed 3 cards" in {
      val hand = CardSet(Set(Card(Two, Spades), Card(Three, Spades), Card(King, Diamonds)))

      hand.highCard shouldBe Card(King, Diamonds)
    }

    "return the high card when passed 3 face cards" in {
      val hand = CardSet(Set(Card(Ace, Spades), Card(Queen, Hearts), Card(King, Diamonds)))

      hand.highCard shouldBe Card(Ace, Spades)
    }
  }

  "Hands" should {
    "return the hand with highest card" in {
      val hand1 = CardSet(Set(Card(Ace, Spades), Card(Three, Spades), Card(King, Diamonds)))
      val hand2 = CardSet(Set(Card(Two, Spades), Card(Three, Spades), Card(King, Diamonds)))
      val hand3 = CardSet(Set(Card(King, Spades), Card(Three, Spades), Card(King, Diamonds)))
      val hand4 = CardSet(Set(Card(King, Spades), Card(Two, Spades), Card(King, Diamonds)))
      CardSet.highHand(hand1, hand2) shouldBe hand1
      CardSet.highHand(hand3, hand1) shouldBe hand1
      CardSet.highHand(hand3, hand2) shouldBe hand3
      CardSet.highHand(hand2, hand3) shouldBe hand3
      CardSet.highHand(hand4, hand3) shouldBe hand3
    }
    "throw an exception" when {
      "both hands have the same value cards" in {
        val hand1 = CardSet(Set(Card(Ace, Spades), Card(Three, Spades), Card(King, Diamonds)))
        val hand2 = CardSet(Set(Card(Ace, Spades), Card(Three, Spades), Card(King, Diamonds)))
        an[IllegalArgumentException] should be thrownBy CardSet.highHand(hand1, hand2)
      }
    }

    "return the pair" when {
      "there are two values that match" in {
        val hand1 = CardSet(Set(Card(Ace, Spades), Card(Three, Spades), Card(Ace, Diamonds)))
        val pair = hand1.getPairs
        pair shouldBe Set(Set(Card(Ace, Spades),Card(Ace, Diamonds)))
      }

      "there are a set of cards with two sets of pairs" in {
        val hand1 = CardSet(Set(Card(Ace, Spades), Card(Ace, Diamonds), Card(Two, Clubs), Card(Two, Hearts)))
        val pair = hand1.getPairs
        pair shouldBe Set(Set(Card(Ace, Spades), Card(Ace, Diamonds)), Set(Card(Two, Clubs), Card(Two, Hearts)))
      }
    }

    "return no pair" when {
      "there are five different values on cards" in {
        val hand1 = CardSet(Set(Card(Ace, Spades), Card(King, Diamonds), Card(Jack, Clubs), Card(Two, Hearts), Card(Three,Hearts)))
        val result:Set[Set[Card]] = hand1.getPairs
        result shouldBe Set.empty
      }
    }


  }

}
