package poker


import org.scalatest.{Matchers, WordSpec}
import poker.com.fun.poker._


class GameSpec extends WordSpec with Matchers{

  "Game" should {

    "deal a hand of cards to each player" in {
      val playerCards:Game = Game.start(2)
      playerCards.hands.size shouldBe 2
    }
    "deal the same number of cards for each player" in {
      val playerCards:Game = Game.start(2)
      playerCards.hands(1).cards.size shouldBe 5
      playerCards.hands(2).cards.size shouldBe 5
    }
    "deal different cards to each player" in {
      val playerCards: Game = Game.start(2)
      playerCards.hands(1) should not be playerCards.hands(2)
    }
    "tell us which player has won when the best hand is a high card" in {
      val player1Cards = CardSet(Set(Card(Ace, Hearts), Card(Two, Clubs)))
      val player2Cards = CardSet(Set(Card(King, Hearts), Card(Three, Clubs)))
      val game = Game(Map(1 -> player1Cards, 2 -> player2Cards))

      game.winner shouldBe Player(1)

      val game2 = Game(Map(2 -> player1Cards, 1 -> player2Cards))

      game2.winner shouldBe Player(2)
    }

    "tell us which player has won when the best hand is a pair against a high card" in {
      val player1Cards = CardSet(Set(Card(Two, Hearts), Card(Two, Clubs)))
      val player2Cards = CardSet(Set(Card(Ace, Hearts), Card(Three, Clubs)))
      val game = Game(Map(1 -> player1Cards, 2 -> player2Cards))

      game.winner shouldBe Player(1)

      val game2 = Game(Map(2 -> player1Cards, 1 -> player2Cards))

      game2.winner shouldBe Player(2)

    }

    "tell us which player has won when the best hand is a pair against a pair" in {
      val player1Cards = CardSet(Set(Card(Two, Hearts), Card(Two, Clubs)))
      val player2Cards = CardSet(Set(Card(Three, Hearts), Card(Three, Clubs)))
      val game = Game(Map(2 -> player1Cards, 1 -> player2Cards))

      game.winner shouldBe Player(1)

      val game2 = Game(Map(1 -> player1Cards, 2 -> player2Cards))

      game2.winner shouldBe Player(2)
    }

    "tell us which player has won when the best hand is a pair against a two pair" in {
      val player1Cards = CardSet(Set(Card(Two, Hearts), Card(Two, Clubs), Card(Three, Hearts), Card(Three, Clubs)))
      val player2Cards = CardSet(Set(Card(Four, Hearts), Card(Four, Clubs)))

      val game = Game(Map(1 -> player1Cards, 2 -> player2Cards))

      game.winner shouldBe Player(1)
    }

    "tell us what hand the winner had" in {
      val player1Cards = CardSet(Set(Card(Ace, Hearts), Card(Two, Clubs)))
      val player2Cards = CardSet(Set(Card(King, Hearts), Card(Three, Clubs)))
      val game = Game(Map(1 -> player1Cards, 2 -> player2Cards))

      game.winner shouldBe Player(1, HighCard)
    }

  }

}
