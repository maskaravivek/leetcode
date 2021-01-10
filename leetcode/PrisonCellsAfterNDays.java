// https://leetcode.com/problems/prison-cells-after-n-days

package leetcode;

import java.util.Arrays;
import java.util.HashSet;

class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if (cells == null || cells.length == 0 || N < 0) {
            return cells;
        }
        int cycle = 0;
        boolean hasCycle = false;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int[] next = updateCells(cells);
            String key = Arrays.toString(next);
            if (set.contains(key)) {
                hasCycle = true;
                break;
            } else {
                set.add(key);
                cycle++;
            }
            cells = next;
        }

        if (hasCycle) {
            N %= cycle;
            for (int i = 0; i < N; i++) {
                cells = updateCells(cells);
            }
        }

        return cells;
    }

    public int[] updateCells(int[] cells) {
        int newCell[] = new int[cells.length];
        for (int j = 1; j < cells.length - 1; j++) {
            newCell[j] = cells[j - 1] == cells[j + 1] ? 1 : 0;
        }
        newCell[0] = 0;
        newCell[7] = 0;
        return newCell;
    }
}
