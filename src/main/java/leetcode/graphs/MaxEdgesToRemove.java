// https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/

package leetcode.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxEdgesToRemove {

    class SetNode {
        public int data;
        public int rank;
        public SetNode parent;

        public SetNode(int data, int rank) {
            this.data = data;
            this.rank = rank;
        }
    }

    class UnionFind {
        Map<Integer, SetNode> map = new HashMap<>();

        public void makeSet(int data) {
            SetNode node = new SetNode(data, 0);
            node.parent = node;
            map.put(data, node);
        }

        public void union(int data1, int data2) {
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

        public SetNode findSetNode(int data) {
            return findSet(map.get(data));
        }

        public int findSet(int data) {
            return findSet(map.get(data)).data;
        }

        public SetNode findSet(SetNode node) {
            SetNode parent = node.parent;
            if (node == parent) {
                return parent;
            }

            node.parent = findSet(parent);
            return node.parent;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {

        UnionFind ua = new UnionFind();
        UnionFind ub = new UnionFind();

        for (int i = 1; i <= n; i++) {
            ua.makeSet(i);
            ub.makeSet(i);
        }

        int count = 0;

        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == 1 || edges[i][0] == 2) {
                continue;
            }

            SetNode parent1 = ua.findSetNode(edges[i][1]);
            SetNode parent2 = ua.findSetNode(edges[i][2]);

            if (parent1 != parent2) {
                count++;
                ua.union(edges[i][1], edges[i][2]);
                ub.union(edges[i][1], edges[i][2]);
            }
        }

        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == 3 || edges[i][0] == 2) {
                continue;
            }
            SetNode parent1 = ua.findSetNode(edges[i][1]);
            SetNode parent2 = ua.findSetNode(edges[i][2]);

            if (parent1 != parent2) {
                count++;
                ua.union(edges[i][1], edges[i][2]);
            }
        }

        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == 3 || edges[i][0] == 1) {
                continue;
            }
            SetNode parent1 = ub.findSetNode(edges[i][1]);
            SetNode parent2 = ub.findSetNode(edges[i][2]);

            if (parent1 != parent2) {
                count++;
                ub.union(edges[i][1], edges[i][2]);
            }
        }

        Set<SetNode> parentA = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            parentA.add(ua.findSetNode(i));
        }

        if (parentA.size() > 1) {
            return -1;
        }

        Set<SetNode> parentB = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            parentB.add(ub.findSetNode(i));
        }

        if (parentB.size() > 1) {
            return -1;
        }

        return edges.length - count;
    }
}
