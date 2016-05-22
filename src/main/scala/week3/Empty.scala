package week3

/**
  * Created by Ricky on 5/21/16.
  */
class Empty extends IntSet{

  def incl(x: Int): IntSet = {
    new NonEmpty(x, new Empty, new Empty)
  }
  def contains(x: Int): Boolean = false
  def union(other: IntSet): IntSet = other
  override def toString = "."
}