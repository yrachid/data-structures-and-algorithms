package com.yrachid.dsakt

sealed class List<out A : Any?> {
    object Nil : List<Nothing>()

    class Cons<T>(val head: T, val tail: List<T>) : List<T>()

    companion object {
        fun sum(list: List<Int>): Int = when (list) {
            is Nil -> 0
            is Cons -> list.head + sum(list.tail)
        }

        operator fun <T> invoke(vararg values: T): List<T> = when {
            values.isEmpty() -> Nil
            else -> Cons(values[0], invoke(*values))
        }
    }
}
