package leetcode;

public class StringCompressionII {
    public int getLengthOfOptimalCompression(String s, int k) {
        char[] arr = s.toCharArray();

        char lastChar = ' ';
        int count = 0;

        int[] chars = new int[s.length()];
        int[] counts = new int[s.length()];
        int[] actualCounts = new int[s.length()];
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == lastChar) {
                count++;
            } else {
                if (count > 0) {
                    chars[idx] = lastChar;
                    counts[idx] = count > 1 ? 1+String.valueOf(count).length() : 1;
                    actualCounts[idx] = count;
                    idx++;
                }
                lastChar = arr[i];
                count = 1;
            }
        }

        if (count > 0) {
            chars[idx] = lastChar;
            counts[idx] = count > 1 ? 1+String.valueOf(count).length() : 1;
            actualCounts[idx] = count;
            idx++;
        }

        while (k > 0) {
            int minidx = 0, min = actualCounts[0];
            for (int j = 1; j < actualCounts.length; j++) {
                if (actualCounts[j] > 0 && actualCounts[j] < min) {
                    minidx = j;
                    min = actualCounts[j];
                }
            }
            k -= counts[minidx];
            counts[minidx] = 0;
            actualCounts[minidx] = 0;
        }

        int len = 0;
        for (int i = 0; i < counts.length; i++) {
            len += counts[i];
        }
        return len;
    }
}