// https://leetcode.com/problems/number-of-atoms/

package leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=726 lang=java
 *
 * [726] Number of Atoms
 */

// @lc code=start
class NumberOfAtoms {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(countOfAtoms(
                "(((U42Se42Fe10Mc31Rh49Pu49Sb49)49V39Tm50Zr44Og6)33((W2Ga48Tm14Eu46Mt12)23(RuRnMn11)7(Yb15Lu34Ra19CuTb2)47(Md38BhCu48Db15Hf12Ir40)7CdNi21(Db40Zr24Tc27SrBk46Es41DsI37Np9Lu16)46(Zn49Ho19RhClF9Tb30SiCuYb16)15)37(Cr48(Ni31)25(La8Ti17Rn6Ce35)36(Sg42Ts32Ca)37Tl6Nb47Rh32NdGa18Cm10Pt49(Ar37RuSb30Cm32Rf28B39Re7F36In19Zn50)46)38(Rh19Md23No22PoTl35Pd35Hg)41)50"));
    }

    public static String countOfAtoms(String formula) {
        Stack<String> stack = new Stack<>();

        char[] arr = formula.toCharArray();

        String element = "";
        String count = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 65 && arr[i] <= 90) {
                if (!element.equals("")) {
                    if (count.equals("")) {
                        stack.push(element + ":1");
                    } else {
                        stack.push(element + ":" + count);
                        count = "";
                    }
                    element = "";
                }
                element = String.valueOf(arr[i]);
            } else if (arr[i] >= 97 && arr[i] <= 122) {
                element += arr[i];
            } else if (arr[i] >= 48 && arr[i] <= 57) {
                count += arr[i];
            } else if (arr[i] == '(') {
                if (!element.equals("")) {
                    if (count.equals("")) {
                        stack.push(element + ":1");
                    } else {
                        stack.push(element + ":" + count);
                        count = "";
                    }
                    element = "";
                }
                stack.push("(");
            } else if (arr[i] == ')') {
                if (!element.equals("")) {
                    if (count.equals("")) {
                        stack.push(element + ":1");
                    } else {
                        stack.push(element + ":" + count);
                        count = "";
                    }
                    element = "";
                }
                i = i + 1;
                while (i < arr.length && arr[i] >= 48 && arr[i] <= 57) {
                    count += arr[i];
                    i++;
                }

                i -= 1;

                List<String> ele = new ArrayList<>();
                while (!stack.peek().equals("(")) {
                    String e = stack.pop();
                    ele.add(e);
                }
                stack.pop();

                int cnt = Integer.parseInt(count);
                for (String e : ele) {
                    String[] data = e.split(":");
                    stack.push(data[0] + ":" + (Integer.parseInt(data[1]) * cnt));
                }
                count = "";
            }
        }

        if (!element.equals("")) {
            if (count.equals("")) {
                stack.push(element + ":1");
            } else {
                stack.push(element + ":" + count);
                count = "";
            }
            element = "";
        }

        TreeMap<String, Integer> map = new TreeMap<>();

        while (!stack.isEmpty()) {
            String[] data = stack.pop().split(":");
            map.put(data[0], map.getOrDefault(data[0], 0) + Integer.parseInt(data[1]));
        }

        StringBuilder sb = new StringBuilder();

        for (String key : map.keySet()) {
            int val = map.get(key);
            if (val > 1) {
                sb.append(key).append(val);
            } else {
                sb.append(key);
            }
        }

        return sb.toString();
    }
}
// @lc code=end
