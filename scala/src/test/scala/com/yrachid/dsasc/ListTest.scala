package com.yrachid.dsasc

import org.scalatest.flatspec.AnyFlatSpec

class ListTest extends AnyFlatSpec {

  it should "sum all values of a list of int" in {
    assertResult(0)(List.sum(Nil))
    assertResult(6)(List.sum(List(1, 2, 3)))
  }

  it should "multiply all values of a list of doubles" in {
    assertResult(0)(List.product(List(0, 2)))
    assertResult(4.0)(List.product(List(2, 2)))
    assertResult(8.0)(List.product(List(2, 2, 2)))
  }

  it should "add element at the beginning of the list when prepending" in {
    assertResult(List(1))(List.prepend(Nil, 1))
    assertResult(List(3, 1, 2))(List.prepend(List(1, 2), 3))
  }

  it should "replace the head of a list" in {
    assertResult(List("A"))(List.replaceHead(Nil, "A"))
    assertResult(List("D", "B", "C"))(List.replaceHead(List("A", "B", "C"), "D"))
  }

  it should "drop n elements of a list" in {
    val iAmImmutable = List(1, 2, 3, 4, 5, 6)

    assertResult(List(3, 4, 5, 6))(List.drop(iAmImmutable, 2))
    assertResult(Nil)(List.drop(iAmImmutable, 6))
  }

  it should "drop elements that match a given predicate" in {
    val iAmImmutable = List(1, 2, 3, 4, 5, 6)

    assertResult(List(3, 4, 5, 6))(List.dropWhile[Int](iAmImmutable, _ <= 2))
  }

  it should "have an accessible tail" in {
    val aList = List(1, 2, 3)

    assertResult(List(2, 3))(List.tail(aList))
  }

}
