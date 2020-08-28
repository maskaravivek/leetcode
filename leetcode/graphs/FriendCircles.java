// https://leetcode.com/problems/friend-circles/

package leetcode.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import models.SetNode;

public class FriendCircles {

    static Map<Long, SetNode> map = new HashMap<>();

    public int findCircleNum(int[][] M) {
        int n = M.length;
        for (int i = 0; i < n; i++) {
            makeSet(i);
        }

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(findSet(i));
        }

        return set.size();
    }

    public static void makeSet(long data) {
        SetNode node = new SetNode(data, 0);
        node.parent = node;
        map.put(data, node);
    }

    public static void union(long data1, long data2) {
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

    public static long findSet(long data) {
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