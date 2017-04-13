package poker.com.fun.poker


sealed trait CardValue { val value:Int}

case object Ace extends CardValue {
  override val value: Int = 14
}
case object Two extends CardValue {
  override val value: Int = 2
}
case object Three extends CardValue {
  override val value: Int = 3
}
case object Four extends CardValue {
  override val value: Int = 4
}
case object Five extends CardValue {
  override val value: Int = 5
}
case object Six extends CardValue {
  override val value: Int = 6
}
case object Seven extends CardValue {
  override val value: Int = 7
}
case object Eight extends CardValue {
  override val value: Int = 8
}
case object Nine extends CardValue {
  override val value: Int = 9
}
case object Ten extends CardValue {
  override val value: Int = 10
}
case object Jack extends CardValue {
  override val value: Int = 11
}
case object Queen extends CardValue {
  override val value: Int = 12
}
case object King extends CardValue {
  override val value: Int = 13
}