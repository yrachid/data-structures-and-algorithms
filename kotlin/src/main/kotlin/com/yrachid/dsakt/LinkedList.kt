package com.yrachid.dsakt

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
