// https://leetcode.com/problems/my-calendar-ii/

package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=731 lang=java
 *
 * [731] My Calendar II
 */

// @lc code=start
class MyCalendarTwo {

    List<int[]> bookings;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] item : bookings) {
            if (Math.max(item[0], start) < Math.min(item[1], end)) {
                if (!bookOld(Math.max(item[0], start), Math.min(item[1], end))) {
                    return false;
                }
            }
        }

        bookings.add(new int[] { start, end });
        return true;
    }

    public boolean bookOld(int start, int end) {
        for (int[] item : overlaps) {
            if (Math.max(item[0], start) < Math.min(item[1], end)) {
                overlaps.clear();
                return false;
            }
        }

        overlaps.add(new int[] { start, end });
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo(); boolean param_1 =
 * obj.book(start,end);
 */
// @lc code=end
