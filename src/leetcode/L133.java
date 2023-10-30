package leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

// Clone Graph
public class L133 {
    HashMap<Node, Node> rMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Integer, Node> visited = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        visited.put(1, new Node(node.val));
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            // add its neighbours to the visited.
            for (Node n : curr.neighbors) {
                Node newNode = new Node(n.val);
                if (!visited.containsKey(n.val)) {
                    queue.add(n);
                    visited.put(n.val, newNode);
                }
                newNode = visited.get(n.val);
                if (!visited.get(curr.val).neighbors.contains(newNode)) visited.get(curr.val).neighbors.add(newNode);
            }
        }
        return visited.get(1);
    }
    public Node cloneGraphRecur(Node node) {
        if (node == null) return null;
        if (!rMap.containsKey(node)) rMap.put(node, new Node(node.val));
        for(Node n : node.neighbors) {
            // if neighbour doesn't exist, clone
            if (!rMap.containsKey(n)) cloneGraphRecur(n);
            if (!rMap.get(node).neighbors.contains(rMap.get(n))) rMap.get(node).neighbors.add(rMap.get(n));
            // clone and add neighbours
        }
        return rMap.get(node);
    }

}
