package berlinClock

case class BerlinClock(hours: Int, minutes: Int, noOfSeconds: Int) {

  def seconds: String = if (noOfSeconds % 2 == 0) "1" else "0"

  def firstRowHours: String = ("1" * (hours/5)).padTo(4, "0").mkString

  def secondRowHours: String = ("1" * (hours%5)).padTo(4, "0").mkString

}
