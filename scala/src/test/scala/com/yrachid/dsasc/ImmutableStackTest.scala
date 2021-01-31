package com.yrachid.dsasc

import org.scalatest.flatspec.AnyFlatSpec

class ImmutableStackTest extends AnyFlatSpec {

  it should "behaves as FILO" in {
    val stack = ImmutableStack(1, 2, 3, 4, 5)

    assertResult(Option(5) -> ImmutableStack(1, 2, 3, 4))(stack.pop())
    assertResult(Option(4) -> ImmutableStack(1, 2, 3))(stack.pop()._2.pop())
    assertResult(Option(3) -> ImmutableStack(1, 2))(stack.pop()._2.pop()._2.pop())
    assertResult(Option(2) -> ImmutableStack(1))(stack.pop()._2.pop()._2.pop()._2.pop())
    assertResult(Option(1) -> ImmutableStack())(stack.pop()._2.pop()._2.pop()._2.pop()._2.pop())
    assertResult(Option.empty -> ImmutableStack())(stack.pop()._2.pop()._2.pop()._2.pop()._2.pop()._2.pop())
  }

}
