package com.yrachid.dsakt

class RecursiveList<T> private constructor(
    private val head: T? = null,
    private val tail: RecursiveList<T>? = null,
    val size: Int = 0
) {

    constructor() : this(null, null, 0)

    operator fun plus(value: T): RecursiveList<T> = RecursiveList(value, this, size + 1)

    override fun toString(): String {
        fun loop(tail: RecursiveList<T>?, acc: String? = null): String = when (tail?.head) {
            null -> acc ?: ""
            else -> loop(
                tail.tail, when (acc) {
                    null -> tail.head.toString()
                    else -> "${tail.head}, $acc"
                }
            )
        }

        return "[${loop(tail)}, $head]"
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
    val immutableList = RecursiveList<String>() + "A" + "B" + "C" + "D"
    val linkedList = LinkedList<String>() + "A" + "B" + "C" + "D"

    println(immutableList)
    println(immutableList.size)

    println(linkedList)
    println(linkedList.size)
}