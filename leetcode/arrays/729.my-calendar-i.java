// https://leetcode.com/problems/my-calendar-i/

package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/*
 * @lc app=leetcode id=729 lang=java
 *
 * [729] My Calendar I
 */

// @lc code=start
class MyCalendar {

    List<int[]> list;
    TreeSet<int[]> treeSet;

    public MyCalendar() {
        list = new ArrayList<>();
        treeSet = new TreeSet<>((int[] a, int[] b) -> a[0] - b[0]);
    }

    public boolean bookOld(int start, int end) {
        for (int[] item : list) {
            if (Math.max(item[0], start) < Math.min(item[1], end)) {
                return false;
            }
        }

        list.add(new int[] { start, end });
        return true;
    }

    public boolean book(int start, int end) {
        int[] booking = new int[] { start, end };

        int[] floor = treeSet.floor(booking);
        int[] ceiling = treeSet.ceiling(booking);

        if (floor != null && start < floor[1] || ceiling != null && end > ceiling[0]) {
            return false;
        }

        treeSet.add(booking);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such: MyCalendar
 * obj = new MyCalendar(); boolean param_1 = obj.book(start,end);
 */
// @lc code=end
