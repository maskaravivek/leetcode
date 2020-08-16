// https://leetcode.com/problems/binary-watch/

package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();

        int arr[] = new int[] { 1, 2, 4, 8, 1, 2, 4, 8, 16, 32 };
        backTrack(arr, 0, 0, 0, num, result);
        return result;
    }

    public void backTrack(int arr[], int position, int hours, int minutes, int limit, List<String> result) {
        if (limit == 0) {
            if (hours < 12 && minutes < 60) {
                StringBuilder builder = new StringBuilder();
                builder.append(hours).append(":").append(minutes <= 9 ? "0" + minutes : minutes);
                result.add(builder.toString());
            }
            return;
        }

        for (int i = position; i < arr.length; i++) {
            if (isHour(i)) {
                hours += arr[i];
            } else {
                minutes += arr[i];
            }

            backTrack(arr, i + 1, hours, minutes, limit - 1, result);

            if (isHour(i)) {
                hours -= arr[i];
            } else {
                minutes -= arr[i];
            }
        }
    }

    public boolean isHour(int position) {
        return position >= 0 && position <= 3;
    }
}