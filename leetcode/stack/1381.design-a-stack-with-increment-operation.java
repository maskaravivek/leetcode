// https://leetcode.com/problems/design-a-stack-with-increment-operation/
package leetcode.stack;

/*
 * @lc app=leetcode id=1381 lang=java
 *
 * [1381] Design a Stack With Increment Operation
 */

// @lc code=start
class CustomStack {
    int maxSize;
    int arr[];
    int idx;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        idx = 0;
    }

    public void push(int x) {
        if (idx >= maxSize) {
            return;
        }
        arr[idx++] = x;
    }

    public int pop() {
        if (idx <= 0) {
            return -1;
        }
        return arr[--idx];
    }

    public void increment(int k, int val) {
        int indexes = idx > k ? k : idx;

        for (int i = 0; i < indexes; i++) {
            arr[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such: CustomStack
 * obj = new CustomStack(maxSize); obj.push(x); int param_2 = obj.pop();
 * obj.increment(k,val);
 */
// @lc code=end
