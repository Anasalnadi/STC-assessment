package com.nado.service;

import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StringService {
    private static final Logger logger = Logger.getLogger(StringService.class.getName());


    public static String reverseWordsInParentheses(String s) {

        if (s.length() <= 1 || s.length() >= 2000) {
            logger.log(Level.WARNING, "Input length is not within the valid range.");
            return s; // Return the original string as is
        }

        if (containsUppercase(s)) {
            logger.log(Level.WARNING, "Input contains uppercase letters.");
            return s;
        }

        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

        findAndReverseWords(chars, stack);

        return new String(chars);
    }

    private static void findAndReverseWords(char[] chars, Stack<Integer> stack) {
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (c == '(') {
                stack.push(i);
            } else if (c == ')' && !stack.isEmpty()) {
                int openParenIndex = stack.pop();
                reverseSubstring(chars, openParenIndex + 1, i - 1);
            }
        }
    }

    private static void reverseSubstring(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    private static boolean containsUppercase(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    }

