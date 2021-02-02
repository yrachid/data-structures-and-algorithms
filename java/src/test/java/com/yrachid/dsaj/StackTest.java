package com.yrachid.dsaj;

import com.yrachid.dsaj.Stack.StackOverflowException;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void behaves_as_lifo() {
        Stack<Integer> stack = new Stack<>(5);

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
        Stack<Integer> s = new Stack<>(3);
        s.push(1);
        s.push(2);
        s.push(3);

        assertEquals(3, s.pop());

        s.push(4);

        assertEquals(4, s.pop());
    }

    @Test
    void throws_exception_when_it_overflows() {
        Stack<Integer> stack = new Stack<>(1);
        stack.push(1);

        StackOverflowException thrown = assertThrows(StackOverflowException.class, () -> stack.push(2));

        assertEquals("Max stack size exceeded", thrown.getMessage());
    }

    @Test
    void indicates_that_it_is_empty() {
        Stack<Integer> empty = new Stack<>(1);
        Stack<Integer> notEmpty = new Stack<>(5);
        notEmpty.push(1);

        assertTrue(empty.isEmpty());
        assertFalse(notEmpty.isEmpty());

        notEmpty.pop();

        assertTrue(notEmpty.isEmpty());
    }

    @Test
    void indicates_that_it_is_full() {
        Stack<Integer> stack = new Stack<>(2);
        stack.push(1);
        stack.push(2);

        assertTrue(stack.isFull());

        stack.pop();

        assertFalse(stack.isFull());
    }

    @Test
    void use_case_reverse_string() {
        String word = "bananas";
        Stack<Character> chars = new Stack<>(word.length());

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            chars.push(word.charAt(i));
        }

        while (!chars.isEmpty()) {
            result.append(chars.pop());
        }

        assertEquals("sananab", result.toString());
    }

    @Test
    void use_case_matching_delimiters() {
        assertTrue(MatchingDelimiters.isBalanced("a{b(c[d]e)f}"));
        assertTrue(MatchingDelimiters.isBalanced("{[()]}"));
        assertTrue(MatchingDelimiters.isBalanced("{{}}"));
        assertTrue(MatchingDelimiters.isBalanced("{}[]()"));
        assertFalse(MatchingDelimiters.isBalanced("a{b(c]d}e"));
        assertFalse(MatchingDelimiters.isBalanced("{(})[{}]"));
    }

    static final class MatchingDelimiters {
        static final Map<String, String> DELIMITERS = new HashMap<String, String>() {{
            put("{", "}");
            put("[", "]");
            put("(", ")");
        }};

        static boolean isOpeningBracket(String value) {
            return DELIMITERS.containsKey(value);
        }

        static boolean isClosingBracket(String value) {
            return DELIMITERS.containsValue(value);
        }

        static boolean matchingBrackets(String opening, String closing) {
            return DELIMITERS.getOrDefault(opening, "").equals(closing);
        }

        static boolean isBalanced(String value) {
            Stack<String> openingBrackets = new Stack<>(value.length());
            String[] tokens = value.split("");
            for (String token : tokens) {
                if (isOpeningBracket(token)) {
                    openingBrackets.push(token);
                    continue;
                }

                if (isClosingBracket(token) && openingBrackets.isEmpty()
                        || !matchingBrackets(openingBrackets.pop(), token)) {
                    return false;
                }
            }

            return openingBrackets.isEmpty();
        }
    }
}