// https://leetcode.com/problems/get-equal-substrings-within-budget

package leetcode;

class GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        int cost[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int currentCost = 0;
        int left = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < cost.length; i++) {
            currentCost += cost[i];

            while (currentCost > maxCost) {
                currentCost -= cost[left++];
            }

            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}