// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfAPhoneNumber {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(letterCombinations("456"));
    }

    public static List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Integer, List<String>> map = new HashMap<>();

        int letter = 0;
        for (int i = 2; i <= 9; i++) {
            for (int j = 0; j < (i == 7 || i == 9 ? 4 : 3); j++) {
                List<String> arr = map.getOrDefault(i, new ArrayList<>());
                arr.add(String.valueOf((char) (letter + 'a')));
                map.put(i, arr);
                letter += 1;
            }
        }
        List<String> result = new ArrayList<>();
        backtrack(map, digits, 0, "", result);
        return result;
    }

    public static void backtrack(Map<Integer, List<String>> map, String digits, int position, String currentString,
            List<String> result) {
        if (currentString.length() == digits.length()) {
            result.add(currentString);
            return;
        }

        int i = currentString.length();

        int num = Integer.parseInt(String.valueOf(digits.charAt(i)));
        List<String> letters = map.get(num);

        for (int j = 0; j < letters.size(); j++) {
            String newStr = currentString + letters.get(j);
            backtrack(map, digits, position + 1, newStr, result);
        }
    }
}