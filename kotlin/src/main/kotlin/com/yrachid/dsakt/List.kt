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

class LinkedList<T> private constructor(private var head: Node<T>?, private var tail: Node<T>?) {

    var size: Int = 0

    constructor() : this(head = null, tail = null)

    internal class Node<T>(val value: T, var next: Node<T>?)

    operator fun plus(value: T): LinkedList<T> {
        if (head == null) {
            head = Node(value, null)
            size += 1
            return this
        }

        return this
    }

    override fun toString(): String {
        var current = head
        var str = ""

        while (current != null) {
            str = "$str, ${current.value}"
            current = current.next
        }

        return "[$str]"
    }
}

fun main() {
    val linkedList = LinkedList<String>() + "A" + "B" + "C" + "D"

    List(1, 2, 3)

    println(linkedList)
    println(linkedList.size)
}