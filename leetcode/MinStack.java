// https://leetcode.com/problems/min-stack
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    List<Integer> arr;
    List<Integer> minArr;
    int idx = 0;

    /** initialize your data structure here. */
    public MinStack() {
        arr = new ArrayList<>();
        minArr = new ArrayList<>();
    }

    public void push(int x) {
        arr.add(x);
        minArr.add(idx > 0 ? Math.min(minArr.get(idx - 1), x) : x);
        idx++;
    }

    public void pop() {
        arr.remove(arr.size() - 1);
        minArr.remove(minArr.size() - 1);
        idx = idx - 1;
    }

    public int top() {
        return arr.get(arr.size() - 1);
    }

    public int getMin() {
        return minArr.get(minArr.size() - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */