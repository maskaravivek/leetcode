// https://leetcode.com/discuss/interview-question/356520

package interview;

import java.util.Arrays;

public class MinNumberOfChairs {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(solution(new int[] { 1, 2, 6, 5, 3 }, new int[] { 5, 5, 7, 6, 8 }));
    }

    public static int solution(int[] S, int[] E) {

        int chairs = 1, min_chairs = 1;

        Arrays.sort(S);
        Arrays.sort(E);

        int sIdx = 1;
        int eIdx = 0;

        while (sIdx < S.length && eIdx < E.length) {
            if (S[sIdx] <= E[eIdx]) {
                chairs++;

                if (chairs > min_chairs) {
                    min_chairs = chairs;
                }
                sIdx++;
            } else {
                chairs--;
                eIdx++;
            }
        }

        return chairs;
    }
}
