//  https://leetcode.com/problems/number-of-operations-to-make-network-connected/

package leetcode.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import models.SetNode;

public class NumberOfOperationsToMakeNetworkConnected {
    static Map<Integer, SetNode> map = new HashMap<>();

    public int makeConnected(int n, int[][] connections) {
        for (int i = 0; i < n; i++) {
            makeSet(i);
        }

        int extraConnections = 0;

        for (int i = 0; i < connections.length; i++) {
            if (!sameParent(connections[i][0], connections[i][1])) {
                union(connections[i][0], connections[i][1]);
            } else {
                extraConnections++;
            }
        }

        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(findSet(i));
        }

        int connectionsNeeded = set.size() - 1;

        if (connectionsNeeded <= extraConnections) {
            return connectionsNeeded;
        } else {
            return -1;
        }
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