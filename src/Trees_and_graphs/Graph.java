package Trees_and_graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class Graph {
	
	ArrayList<GraphNode> nodes = new ArrayList<GraphNode>();

	public static void main(String[] args) {
		Graph g = new Graph();
		g.nodes.add(new GraphNode(0));
		g.nodes.add(new GraphNode(1));
		g.nodes.add(new GraphNode(2));
		g.nodes.add(new GraphNode(3));
		g.nodes.add(new GraphNode(4));
		
		g.nodes.get(0).addDirectedPath(g.nodes.get(1));
		g.nodes.get(0).addDirectedPath(g.nodes.get(2));
		g.nodes.get(2).addDirectedPath(g.nodes.get(3));
		g.nodes.get(2).addDirectedPath(g.nodes.get(4));
		g.nodes.get(1).addDirectedPath(g.nodes.get(4));
		
		g.printBFS(g.nodes.get(0));
		g.printDFS(g.nodes.get(0));
		
		
	}

	private void printBFS(GraphNode startNode) {
		
		ArrayList<GraphNode> queue = new ArrayList<GraphNode>();
		HashSet<GraphNode> visited = new HashSet<GraphNode>();
		queue.add(startNode);
		while(!queue.isEmpty()) {
			GraphNode front = queue.get(0);
			queue.remove(0);
			if(visited.contains(front)) {
				continue;
			}
			visited.add(front);
			System.out.print(front.data+" ");
			for(GraphNode n: front.adjacentNodes) {
				queue.add(n);
			}
		}
		System.out.println();
		
	}
	
	private void printDFS(GraphNode startNode) {
		ArrayList<GraphNode> stack = new ArrayList<GraphNode>();
		HashSet<GraphNode> visited = new HashSet<GraphNode>();
		stack.add(startNode);
		while(!stack.isEmpty()) {
			GraphNode end = stack.get(0);
			stack.remove(0);
			if(!visited.contains(end)) {
				System.out.print(end.data+" ");
			}
			visited.add(end);
			for(GraphNode n: end.adjacentNodes) {
				stack.add(0, n);
			}
		}
		System.out.println();
	}

}
