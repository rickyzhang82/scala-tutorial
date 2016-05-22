package week3

/**
  * Created by Ricky on 5/21/16.
  */
class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet{
  def incl(x: Int): IntSet ={
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if(x > elem) new NonEmpty(elem, left, right incl x)
    else this
  }

  def contains(x: Int): Boolean ={
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  }

  def union(other: IntSet): IntSet ={
    ((left union right) union other) incl elem
  }

  override def toString = { "{" + left + ", " + elem + "," + right + "}"}
}
