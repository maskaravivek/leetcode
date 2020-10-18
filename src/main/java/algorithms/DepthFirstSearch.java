package algorithms;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import leetcode.Node;

public class DepthFirstSearch {
    public void depthFirstSearch(Node node) {
        Stack<Node> stack = new Stack<>();
        Set<Node> seen = new HashSet<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            if (!seen.contains(current)) {
                System.out.println(current.val);
                seen.add(current);
            }

            for (Node child : current.children) {
                if(!seen.contains(child)) {
                    stack.push(child);
                }
            }
        }
    }
}