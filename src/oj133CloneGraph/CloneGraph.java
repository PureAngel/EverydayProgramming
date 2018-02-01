package oj133CloneGraph;

import java.util.*;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


 OJ's undirected graph serialization:
 Nodes are labeled uniquely.

 We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 As an example, consider the serialized graph {0,1,2#1,2#2,2}.

 The graph has a total of three nodes, and therefore contains three parts as separated by #.

 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 Visually, the graph looks like the following:

    1
   / \
  /   \
 0 --- 2
      / \
      \_/

 * Created by xueyingbai on 1/31/18.
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        // get all the nodes
        queue.offer(node);
        set.add(node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode currentNode = queue.poll();
            for(UndirectedGraphNode neighbor: currentNode.neighbors) {
                if(!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        ArrayList<UndirectedGraphNode> nodeList = new ArrayList<UndirectedGraphNode>(set);

        // clone all the nodes
        for(UndirectedGraphNode n: nodeList) {
            map.put(n, new UndirectedGraphNode(n.label));
        }

        // clone all the edges
        for(UndirectedGraphNode n: nodeList) {
            UndirectedGraphNode newNode = map.get(n);
            for(UndirectedGraphNode neighbor: n.neighbors) {
                UndirectedGraphNode newNeighbor = map.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }

        return map.get(node);
    }
}
