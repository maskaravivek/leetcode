package interview;

import java.util.HashMap;
import java.util.Map;

public class TimeToTypeAString {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(timeToTypeAString("abcdefghijklmnopqrstuvwxy", "cba"));
    }

    public static int timeToTypeAString(String keyboard, String text) {
        Map<Character, Integer> map = new HashMap<>();

        int start = 0;

        for (int i = 0; i < keyboard.length(); i++) {
            map.put(keyboard.charAt(i), start++);
        }

        char[] arr = text.toCharArray();

        int lastIndex = 0;
        int time = 0;
        for (int i = 0; i < arr.length; i++) {
            int newIndex = map.get(arr[i]);
            time += Math.abs((map.get(arr[i]) - lastIndex));
            lastIndex = newIndex;
        }

        return time;
    }
}
