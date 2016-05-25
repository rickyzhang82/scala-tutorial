import week3._

import scala.math.Ordered

class WrapperInt(val value: Int) extends Ordered[WrapperInt]{
  def compare(that: WrapperInt): Int = this.value - that.value
  override def toString = value.toString
}

val intSet = new NonEmpty[WrapperInt](new WrapperInt(1), new Empty[WrapperInt], new Empty[WrapperInt])




