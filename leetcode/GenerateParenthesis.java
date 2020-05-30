package leetcode;

import java.util.*;
import java.lang.*;
import java.io.*;

class GenerateParenthesis {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(generateParenthesis(4));
    }

    public static List<String> generateParenthesis(final int n) {
        final List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public static void generateAll(final char[] current, final int position, final List<String> results) {
        if (current.length == position) {
            if (valid(current)) {
                results.add(new String(current));
            }
        } else {
            current[position] = '(';
            generateAll(current, position + 1, results);
            current[position] = ')';
            generateAll(current, position + 1, results);
        }
    }

    public static boolean valid(final char[] current) {
        int balance = 0;
        for (final char c : current) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}