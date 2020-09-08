// https://leetcode.com/discuss/interview-question/356935/

package interview;

import java.util.TreeSet;

public class PizzaShop {

    public static void main(final String[] args) throws java.lang.Exception {
        System.out.println(solution(new int[] { 800, 850, 900 }, new int[] { 100, 150 }, 1000));

        System.out.println(solution(new int[] { 850, 900 }, new int[] { 200, 250 }, 1000));

        System.out.println(solution(new int[] { 1100, 900 }, new int[] { 200 }, 1000));
    }

    public static int solution(int[] pizzas, int[] toppings, int x) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(0);
        for (int i = 0; i < toppings.length; i++) {
            treeSet.add(toppings[i]);
            for (int j = i + 1; j < toppings.length; j++) {
                treeSet.add(toppings[i] + toppings[j]);
            }
        }

        int closest = 0, current_closest = 0;
        for (int i = 0; i < pizzas.length; i++) {
            if (x - pizzas[i] == 0) {
                return x;
            } else if (x - pizzas[i] > 0) {
                int floor = treeSet.floor((x - pizzas[i]));
                if (floor == x - pizzas[i]) {
                    return x;
                }

                Integer ceiling = treeSet.ceiling(x - pizzas[i]);
                if (ceiling == null) {
                    ceiling = floor;
                }

                int diff1 = Math.abs(x - (pizzas[i] + floor));
                int diff2 = Math.abs(x - (pizzas[i] + ceiling));

                if (diff1 <= diff2) {
                    current_closest = pizzas[i] + floor;
                } else {
                    current_closest = pizzas[i] + ceiling;
                }
            } else {
                current_closest = pizzas[i];
            }

            if (Math.abs(current_closest - x) <= Math.abs(closest - x)) {
                closest = current_closest;
            }

        }
        return closest;
    }
}
