// https://leetcode.com/problems/letter-tile-possibilities/

package leetcode.backtracking;

import java.util.Arrays;

public class LetterTilePossibilities {
    static int count = 0;

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(numTilePossibilities("AAB"));
    }

    public static int numTilePossibilities(String tiles) {
        char arr[] = tiles.toCharArray();
        Arrays.sort(arr);
        permute(arr, new boolean[arr.length]);
        return count - 1;
    }

    public static void permute(char[] tiles, boolean[] used) {
        count++;
        for (int i = 0; i < tiles.length; i++) {
            if (used[i] || (i > 0 && tiles[i] == tiles[i - 1] && !used[i - 1])) {
                continue;
            }

            used[i] = true;
            permute(tiles, used);
            used[i] = false;
        }
    }
}