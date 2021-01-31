package com.yrachid.dsaj;

import com.yrachid.dsaj.Stack.StackOverflowException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void behaves_as_lifo() {
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        assertEquals(5, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void overrides_used_indexes() {
        Stack s = new Stack(3);
        s.push(1);
        s.push(2);
        s.push(3);

        assertEquals(3, s.pop());

        s.push(4);

        assertEquals(4, s.pop());
    }

    @Test
    void throws_exception_when_it_overflows() {
        Stack stack = new Stack(1);
        stack.push(1);

        StackOverflowException thrown = assertThrows(StackOverflowException.class, () -> stack.push(2));

        assertEquals("Max stack size exceeded", thrown.getMessage());
    }

    @Test
    void indicates_that_it_is_empty() {
        Stack empty = new Stack(1);
        Stack notEmpty = new Stack(5);
        notEmpty.push(1);

        assertTrue(empty.isEmpty());
        assertFalse(notEmpty.isEmpty());

        notEmpty.pop();

        assertTrue(notEmpty.isEmpty());
    }

    @Test
    void indicates_that_it_is_full() {
        Stack stack = new Stack(2);
        stack.push(1);
        stack.push(2);

        assertTrue(stack.isFull());

        stack.pop();

        assertFalse(stack.isFull());
    }
}