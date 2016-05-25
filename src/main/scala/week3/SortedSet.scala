package week3

import scala.math.Ordered

/**
  * Created by Ricky on 5/21/16.
  */
/**
  *
  * Note: Ordered vs Ordering
  * Ordered ==> java Comparable
  * Ordering ==> java Comparator. There are may be different ordering way!!!
  * But why the heck Int, Long and etc are not Ordering?
  */
abstract class SortedSet[T <: Ordered[T]] {
  def incl(x: T): SortedSet[T]
  def contains(x: T): Boolean
  def union(other: SortedSet[T]): SortedSet[T]
}

class Empty [T <: Ordered[T]] extends SortedSet[T]  {

  def incl(x: T): SortedSet[T] = {
    new NonEmpty(x, new Empty, new Empty)
  }
  def contains(x: T): Boolean = false
  def union(other: SortedSet[T]): SortedSet[T] = other
  override def toString = "."
}

class NonEmpty[T <: Ordered[T]](elem: T, left: SortedSet[T], right: SortedSet[T]) extends SortedSet[T]{
  def incl(x: T): SortedSet[T] ={
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if(x > elem) new NonEmpty(elem, left, right incl x)
    else this
  }

  def contains(x: T): Boolean ={
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  }

  def union(other: SortedSet[T]): SortedSet[T] ={
    ((left union right) union other) incl elem
  }

  override def toString = { "{" + left + ", " + elem + "," + right + "}"}
}