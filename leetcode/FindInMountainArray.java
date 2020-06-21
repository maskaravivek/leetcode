package leetcode;

public class FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int left = 0, right = len - 1;

        int peak = -1;
        while (left < right) {
            int mid = (left + right) / 2;
            int mide = mountainArr.get(mid);
            int midMinuse = mountainArr.get(mid - 1);
            int midPluse = mountainArr.get(mid + 1);
            if (mid > 0 && mid < len - 1 && mide > midMinuse && mide > midPluse) {
                peak = mid;
                break;
            }

            if (mide < midPluse) {
                left = mid;
            } else {
                right = mid;
            }
        }

        left = 0;
        right = peak;

        while (left <= right) {
            int mid = (left + right) / 2;
            int mide = mountainArr.get(mid);
            if (mide > target) {
                right = mid - 1;
            } else if (mide < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        left = peak;
        right = len - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int mide = mountainArr.get(mid);
            if (mide > target) {
                left = mid + 1;
            } else if (mide < target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

interface MountainArray {
    public int get(int index);

    public int length();
}