package dojo

import org.scalatest.{Matchers, WordSpec}

class DojoPoker extends WordSpec with Matchers {

  case class PokerGame(player1: List[(Int,String)], player2: List[(Int,String)]){
    def winner : String = {
      if (player1.head._1 == player1.tail.head._1){
        "player1"
      }
      else
      if (player1.sortBy(_._1).reverse.head._1 > player2.sortBy(_._1).reverse.head._1){
        "player1"
      } else {
        "player2"
      }
    }
  }

  "The game" should {
    "return the winning player" when {
      "player one has the best hand" in {
        val player1 = List((5, "H"), (3, "C"))
        val player2 = List((4, "C"), (2, "S"))

        val newGame: PokerGame = PokerGame(player1, player2)
        newGame.winner shouldBe "player1"
      }

      "player two has the best hand" in {
        val player1 = List((5, "H"), (3, "C"))
        val player2 = List((8, "C"), (2, "S"))

        val newGame: PokerGame = PokerGame(player1, player2)
        newGame.winner shouldBe "player2"
      }
      "player two has the best hand because of the second card" in {
        val player1 = List((5, "H"), (3, "C"))
        val player2 = List((3, "C"), (8, "S"))

        val newGame: PokerGame = PokerGame(player1, player2)
        newGame.winner shouldBe "player2"
      }
      "player one has a pair" in {
        val player1 = List((2, "H"), (2, "C"))
        val player2 = List((8, "C"), (4, "S"))

        val newGame: PokerGame = PokerGame(player1, player2)
        newGame.winner shouldBe "player1"
      }
    }
  }

}
