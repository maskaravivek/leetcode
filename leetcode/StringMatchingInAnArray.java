// https://leetcode.com/problems/string-matching-in-an-array

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringMatchingInAnArray {

    public static void main(final String[] args) throws java.lang.Exception {
        String arr[] = new String[] { "mass", "as", "hero", "superhero" };
        System.out.println(stringMatching(arr));
    }

    public static List<String> stringMatching(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));

        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(word)) {
                    result.add(word);
                    break;
                }
            }
        }
        return result;
    }
}