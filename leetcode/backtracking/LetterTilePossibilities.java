package leetcode.backtracking;

import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<String>();
        backtracking(tiles, 0, set);
        return set.size();
    }

    public void backtracking(String tiles, int position, Set<String> set) {

        for (int i = position; i < tiles.length(); i++) {
            
        }
    }
}