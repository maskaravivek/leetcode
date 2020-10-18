// https://leetcode.com/problems/satisfiability-of-equality-equations

package leetcode.graphs;

import java.util.HashMap;
import java.util.Map;

import models.SetNode;

public class SatisfiabilityOfEqualityEquations {
    static Map<Integer, SetNode> map = new HashMap<>();

    public boolean equationsPossible(String[] equations) {

        for (int i = 0; i < equations.length; i++) {
            String equation = equations[i];
            int first = equation.charAt(0);
            int last = equation.charAt(3);

            if (!map.containsKey(first)) {
                makeSet(first);
            }

            if (!map.containsKey(last)) {
                makeSet(last);
            }

            if (equation.charAt(1) == equation.charAt(2)) {
                union(first, last);
            }
        }

        for (int i = 0; i < equations.length; i++) {
            String equation = equations[i];
            int first = equation.charAt(0);
            int last = equation.charAt(3);

            long set1 = findSet(first);
            long set2 = findSet(last);

            if ((equation.charAt(1) == equation.charAt(2) && set1 == set2)
                    || (equation.charAt(1) != equation.charAt(2) && set1 != set2)) {
                continue;
            } else {
                return false;
            }

        }

        return true;
    }

    public static void makeSet(int data) {
        SetNode node = new SetNode(data, 0);
        node.parent = node;
        map.put(data, node);
    }

    public static boolean sameParent(int data1, int data2) {
        SetNode node1 = map.get(data1);
        SetNode node2 = map.get(data2);

        SetNode parent1 = findSet(node1);
        SetNode parent2 = findSet(node2);

        if (parent1 == parent2) {
            return true;
        }
        return false;
    }

    public static void union(int data1, int data2) {
        SetNode node1 = map.get(data1);
        SetNode node2 = map.get(data2);

        SetNode parent1 = findSet(node1);
        SetNode parent2 = findSet(node2);

        if (parent1 == parent2) {
            return;
        }

        if (parent1.rank >= parent2.rank) {
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
    }

    public static long findSet(int data) {
        return findSet(map.get(data)).data;
    }

    public static SetNode findSet(SetNode node) {
        SetNode parent = node.parent;
        if (node == parent) {
            return parent;
        }

        node.parent = findSet(parent);
        return node.parent;
    }
}