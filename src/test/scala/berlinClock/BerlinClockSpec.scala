package berlinClock

import org.scalatest.{Matchers, WordSpec}

class BerlinClockSpec extends WordSpec with Matchers {

  "BerlinClock" should {
    "return a representation of seconds" when {
      "the time is odd" in {
        BerlinClock(5, 5, 21).seconds shouldBe "0"
      }

      "the time is even" in {
        BerlinClock(5 ,5 ,20).seconds shouldBe "1"
      }
    }

    "return a representation of first row hours" when {
      "the hour is 1" in {
        BerlinClock(1 ,5 ,20).firstRowHours shouldBe "0000"
      }

      "the hour is 5" in {
        BerlinClock(5, 5, 20).firstRowHours shouldBe "1000"
      }

      "the hour is 10" in {
        BerlinClock(10, 5, 20).firstRowHours shouldBe "1100"
      }

      "the hour is 15" in {
        BerlinClock(15, 5, 20).firstRowHours shouldBe "1110"
      }
    }

    "return a representation of the second row hours" when {
      "the hour is 1" in {
        BerlinClock(1, 3, 3).secondRowHours shouldBe "1000"
      }

      "the hour is 2" in {
        BerlinClock(2, 3, 3).secondRowHours shouldBe "1100"
      }

      "the hour is 3" in {
        BerlinClock(3, 3, 3).secondRowHours shouldBe "1110"
      }

      "the hour is 4" in {
        BerlinClock(4 ,3, 3).secondRowHours shouldBe "1111"
      }

      "the hour is 5" in {
        BerlinClock(5, 3, 3).secondRowHours shouldBe "0000"
      }

      "the hour is 6" in {
        BerlinClock(6, 3, 3).secondRowHours shouldBe "1000"
      }

      }
  }

}
