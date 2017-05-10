package poker

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by grahammanderson on 10/05/2017.
  */
class GameSpec extends WordSpec with Matchers{

  "Game" should {

    "return two set of cards" when {

      "two players join the game" in {
        val playerCards:Map[Int, Set[Card]] = Game.start(2)
        playerCards.size shouldBe 2
      }

    }

  }

}
