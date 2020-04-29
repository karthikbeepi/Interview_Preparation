package Trees_and_graphs;

import java.util.ArrayList;

public class GraphNode {
	
	int data;
	ArrayList<GraphNode> adjacentNodes;
	
	public GraphNode(int val) {
		data = val;
		adjacentNodes = new ArrayList<GraphNode>();
	}
	
	public void addDirectedPath(GraphNode n) {
		this.adjacentNodes.add(n);
	}
	
	public void addUndirectedPath(GraphNode n) {
		this.adjacentNodes.add(n);
		n.adjacentNodes.add(this);
	}
}
