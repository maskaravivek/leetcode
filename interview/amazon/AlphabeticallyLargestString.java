package interview.amazon;

import java.util.Set;
import java.util.TreeMap;

public class AlphabeticallyLargestString {

    public static void main(String[] args) {
        System.out.println(alphabeticallyLargestString("baccc", 2));
        System.out.println(alphabeticallyLargestString("cbddd", 2));
        System.out.println(alphabeticallyLargestString("cbdddddddddddddddddddddd", 2));
    }

    public static String alphabeticallyLargestString(String s, int k) {
        TreeMap<Character, Integer> map = new TreeMap<>((a, b) -> b - a);

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        String result = "";
        int count = 0;
        Set<Character> sortedKeys = map.keySet();

        char[] keys = new char[sortedKeys.size()];

        int idx = 0;
        for (Character key : sortedKeys) {
            keys[idx++] = key;
        }

        int keyIdx = 0;
        int currentUseCount = 0;

        while (keyIdx < keys.length) {
            if (currentUseCount >= k) {
                int tempIdx = keyIdx + 1;
                while(tempIdx < keys.length && (map.get(keys[tempIdx]) == 0)) {
                    tempIdx += 1;
                }
                
                if(tempIdx >= keys.length) {
                	break;
                }

                result += keys[tempIdx];
                map.put(keys[tempIdx], map.get(keys[tempIdx]) - 1);
                currentUseCount = 0;
            }
            if (map.get(keys[keyIdx]) > 0) {
                result += keys[keyIdx];
                currentUseCount++;
                map.put(keys[keyIdx], map.get(keys[keyIdx]) - 1);
            } else {
                keyIdx++;
            }

        }

        return result;
    }
}
