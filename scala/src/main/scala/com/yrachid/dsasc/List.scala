package com.yrachid.dsasc

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {

  @scala.annotation.tailrec
  def foldRight[A, B](values: List[A], accumulation: B)(operation: (A, B) => B): B = values match {
    case Nil => accumulation
    case Cons(x, xs) => foldRight(xs, operation(x, accumulation))(operation)
  }

  def sum(values: List[Int]): Int = foldRight(values, 0)(_ + _)

  def product(values: List[Double]): Double = foldRight(values, 1.0)(_ * _)

  def prepend[A](list: List[A], value: A): List[A] = list match {
    case Nil => Cons(value, Nil)
    case _ => Cons(value, list)
  }

  def replaceHead[A](list: List[A], value: A): List[A] = list match {
    case Nil => Cons(value, Nil)
    case Cons(_, xs) => Cons(value, xs)
  }

  @scala.annotation.tailrec
  def drop[A](values: List[A], n: Int): List[A] = (values, n) match {
    case (_, 0) => values
    case (Cons(_, xs), _) => drop(xs, n - 1)
  }

  @scala.annotation.tailrec
  def dropWhile[A](values: List[A])(predicate: A => Boolean): List[A] = values match {
    case Nil => values
    case Cons(x, xs) if predicate(x) => dropWhile(xs)(predicate)
    case _ => values
  }

  def tail[A](values: List[A]): List[A] = drop(values, 1)

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
}
