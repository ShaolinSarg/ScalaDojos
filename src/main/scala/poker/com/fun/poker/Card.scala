package poker.com.fun.poker

/**
  * Created by davidsarginson on 17/03/2017.
  */
case class Card(value: String, s: String) {

  if(value != "A" && value != "2" && value != "4" && value != "5" && value != "3") throw new IllegalArgumentException("Invalid card value")

  val suite = s match {
    case "C" => "Club"
    case "D" => "Diamonds"
    case "H" => "Hearts"
    case "S" => "Spades"
    case _ => throw new IllegalArgumentException("Invalid suit value")
  }

}
