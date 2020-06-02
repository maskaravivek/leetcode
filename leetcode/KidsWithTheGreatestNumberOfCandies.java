// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }

        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i] + extraCandies >= max);
        }
        return result;
    }
}