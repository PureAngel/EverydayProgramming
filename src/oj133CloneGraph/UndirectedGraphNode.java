package oj133CloneGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xueyingbai on 1/31/18.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
