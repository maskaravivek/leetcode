// https://leetcode.com/problems/design-compressed-string-iterator/

package leetcode.strings;

import java.util.Arrays;

public class StringIterator {

    char[] keys;
    int[] counts;
    int currentIdx = 0;

    public static void main(String[] args) {
        StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
    }

    public StringIterator(String compressedString) {
        char[] arr = compressedString.toCharArray();

        int charsCnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] >= 97 && arr[i] <= 122) || (arr[i] >= 65 && arr[i] <= 90)) {
                charsCnt++;
            }
        }

        System.out.println(charsCnt);

        keys = new char[charsCnt];
        counts = new int[charsCnt];

        int len = compressedString.length();

        int idx = 0;
        int keyIdx = 0, countsIdx = 0;
        String num = "";
        while (idx < len) {
            keys[keyIdx++] = arr[idx++];

            System.out.println(arr[idx]);
            while (idx < len && arr[idx] >= 48 && arr[idx] <= 57) {
                System.out.println(arr[idx]);
                num += arr[idx++];
            }
            counts[countsIdx++] = Integer.parseInt(num);
            num = "";
        }

        System.out.println(Arrays.toString(keys));
        System.out.println(Arrays.toString(counts));
    }

    public char next() {
        if (!hasNext()) {
            return ' ';
        }
        char c = keys[currentIdx];
        counts[currentIdx]--;
        if (counts[currentIdx] == 0) {
            currentIdx++;
        }
        return c;
    }

    public boolean hasNext() {
        return currentIdx < keys.length;
    }
}
