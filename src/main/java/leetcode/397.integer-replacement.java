// https://leetcode.com/problems/integer-replacement/

package leetcode;

/*
 * @lc app=leetcode id=397 lang=java
 *
 * [397] Integer Replacement
 */

// @lc code=start
class IntegerReplacement {
    public int integerReplacement(int n) {
        return replacements((long) n, 0);
    }

    public int replacements(long n, int count) {
        if (n == 1) {
            return count;
        }
        while (n % 2 == 0) {
            n /= 2;
            count++;
        }

        if (n == 1) {
            return count;
        }

        return Math.min(replacements(n + 1, count + 1), replacements(n - 1, count + 1));
    }
}
// @lc code=end
