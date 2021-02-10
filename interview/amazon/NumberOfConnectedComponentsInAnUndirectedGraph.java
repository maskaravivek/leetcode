// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

package interview.amazon;

import java.util.*;

class NumberOfConnectedComponentsInAnUndirectedGraph {
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
    
    public int countComponents(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind();
        
        for(int i=0; i< n; i++) {
            unionFind.makeSet(i);
        }
        
        for(int i=0; i< edges.length; i++) {
            unionFind.union(edges[i][0], edges[i][1]);
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i=0; i< n; i++) {
            set.add(unionFind.findSet(i));
        }
        
        return set.size();
    }
}

// dfs solution

// class Solution {
//     public int countComponents(int n, int[][] edges) {
//         Map<Integer, List<Integer>> graph = new HashMap<>();
        
//         for(int i=0; i< n; i++) {
//             graph.put(i, new ArrayList<>());
//         }
        
//         for(int i=0; i< edges.length; i++) {
//             graph.get(edges[i][0]).add(edges[i][1]);
//             graph.get(edges[i][1]).add(edges[i][0]);
//         }
        
//         Set<Integer> visited = new HashSet<>();
        
//         int count = 0;
//         for(int i=0; i< n; i++) {
//             if(!visited.contains(i)) {
//                 visited.add(i);
//                 dfs(graph, visited, i);
//                 count++;
//             }
//         }
//         return count;
//     }
    
//     public void dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int node) {
//         for(Integer n: graph.get(node)) {
//             if(!visited.contains(n)) {
//                 visited.add(n);
//                 dfs(graph, visited, n);
//             }
//         }
//     }
// }