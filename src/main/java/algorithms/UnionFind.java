package algorithms;

import java.util.HashMap;
import java.util.Map;

import models.SetNode;

public class UnionFind {

    static Map<Long, SetNode> map = new HashMap<Long, SetNode>();

    public static void main(final String[] args) throws java.lang.Exception {
        makeSet(1);
        makeSet(2);
        makeSet(3);
        makeSet(4);
        makeSet(5);
        makeSet(6);
        makeSet(7);

        union(1, 2);
        union(2, 3);
        union(4, 5);
        union(6, 7);
        union(5, 6);
        union(3, 7);

        System.out.println(findSet(1));
        System.out.println(findSet(2));
        System.out.println(findSet(3));
        System.out.println(findSet(4));
        System.out.println(findSet(5));
        System.out.println(findSet(6));
        System.out.println(findSet(7));
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