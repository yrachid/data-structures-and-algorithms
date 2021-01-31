package com.yrachid.dsasc

final case class ImmutableStack[T] private(private val items: List[T], private val size: Int) {

  def this() = this(items = List[T](), size = 0)

  def +(value: T): ImmutableStack[T] = push(value)

  def push(value: T): ImmutableStack[T] = new ImmutableStack(List.prepend(items, value), size + 1)

  def pop(): (Option[T],  ImmutableStack[T]) = items match {
    case Nil => (Option.empty, this)
    case Cons(h, t) => (Option(h), new ImmutableStack(t, size - 1))
  }
}

object ImmutableStack {
  def empty[S](): ImmutableStack[S] = new ImmutableStack[S]()
  def apply[S](values: S*): ImmutableStack[S] = values.foldLeft(empty[S]())(_ + _)
}
