// https://leetcode.com/problems/redundant-connection

package leetcode.graphs;

import java.util.HashMap;
import java.util.Map;

import models.SetNode;

public class RedundantConnection {

    static Map<Integer, SetNode> map = new HashMap<>();

    public int[] findRedundantConnection(int[][] edges) {
        for (int i = 1; i <= edges.length; i++) {
            makeSet(i);
        }

        for (int i = 1; i <= edges.length; i++) {
            SetNode node1 = map.get(edges[i][0]);
            SetNode node2 = map.get(edges[i][1]);

            SetNode parent1 = findSet(node1);
            SetNode parent2 = findSet(node2);

            if (parent1 == parent2) {
                return edges[i];
            } else {
                union(edges[i][0], edges[i][1]);
            }
        }

        return new int[] {};
    }

    public static void makeSet(int data) {
        SetNode node = new SetNode(data, 0);
        node.parent = node;
        map.put(data, node);
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