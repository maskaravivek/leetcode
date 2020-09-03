// https://leetcode.com/problems/robot-return-to-origin/

package leetcode.arrays;

/*
 * @lc app=leetcode id=657 lang=java
 *
 * [657] Robot Return to Origin
 */

// @lc code=start
class RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {
        char[] arr = moves.toCharArray();

        int startx = 0, starty = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'U') {
                starty += 1;
            } else if (arr[i] == 'D') {
                starty -= 1;
            } else if (arr[i] == 'L') {
                startx -= 1;
            } else {
                startx += 1;
            }
        }

        return startx == 0 && starty == 0;
    }
}
// @lc code=end
