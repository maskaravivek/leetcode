package interview;

import java.util.Arrays;

public class CompareStrings {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(Arrays.toString(compareStrings("abcd aabc bd", "aaa aa")));
    }

    public static int[] compareStrings(String a, String b) {
        String[] A = a.split(" ");
        String[] B = b.split(" ");

        int[] arrA = new int[A.length];
        int[] arrB = new int[B.length];

        for (int i = 0; i < A.length; i++) {
            int[] freq = new int[26];

            for (int j = 0; j < A[i].length(); j++) {
                freq[A[i].charAt(j) - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                if (freq[j] > 0) {
                    arrA[i] = freq[j];
                    break;
                }
            }
        }

        Arrays.sort(arrA);

        for (int i = 0; i < B.length; i++) {
            int[] freq = new int[26];

            for (int j = 0; j < B[i].length(); j++) {
                freq[B[i].charAt(j) - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                if (freq[j] > 0) {
                    arrB[i] = freq[j];
                    break;
                }
            }
        }

        int[] result = new int[B.length];

        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < arrA.length; j++) {
                if (arrA[j] < arrB[i]) {
                    result[i]++;
                } else {
                    break;
                }
            }
        }

        return result;
    }
}
