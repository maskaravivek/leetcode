// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

package leetcode;

public class FirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        if(left == right) {
            return nums[left] !=target? new int[] { -1, -1 }: new int[] { left, left };
        }

        int tidx = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                tidx = mid;
                break;
            } else if(left == right) {
                break;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        
        if(tidx==-1) {
            return new int[] { -1, -1 };
        }

        int tleft = tidx, tright = tidx;

        while (tleft>=0 && nums[tleft] == target) {
            tleft--;
        }

        while (tright< nums.length && nums[tright] == target) {
            tright++;
        }
        return new int[] { ++tleft, --tright };
    }
}