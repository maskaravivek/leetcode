package algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import leetcode.Node;

public class BreadthFirstSearch {
    public void breadthFirstSearch(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> seen = new HashSet<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (!seen.contains(current)) {
                System.out.println(current.val);
                seen.add(current);
            }

            for (Node child : current.children) {
                if (!seen.contains(child)) {
                    queue.add(child);
                }
            }
        }
    }
}