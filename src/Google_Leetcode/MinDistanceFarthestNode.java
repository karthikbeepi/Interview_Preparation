package Google_Leetcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MinDistanceFarthestNode {
	
	class Node {
		int val;
		HashMap<Node, Integer> adjNodes;
		public Node(int i) {
			val = i;
			adjNodes = new HashMap<Node, Integer>();
			adjNodes.put(this, 0);
		}
	}
	
	HashMap<Integer,Node> allNodes;
	
	public MinDistanceFarthestNode(int i) {
		allNodes = new HashMap<Integer, MinDistanceFarthestNode.Node>();
		for(int j=1; j<=i; j++) {
			allNodes.put(j, new Node(j));
		}
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int n = 6;
		int[][] edges = new int[][] {
			{1, 2},
			{2, 3},
			{3, 4},
			{4, 5},
			{5, 6}
		};
		MinDistanceFarthestNode obj = new MinDistanceFarthestNode(n);
		obj.addEdges(edges);
		System.out.println(obj.minDistance());
		

	}

	private void addEdges(int[][] edges) {
		
		for(int[] a: edges) {
			Node src = allNodes.get(a[0]);
			Node dest = allNodes.get(a[1]);
			src.adjNodes.put(dest, 1);
			dest.adjNodes.put(src, 1);
		}
		
	}


	private int minDistance() {
		
		int minDistace = Integer.MAX_VALUE;
		Node shortestDistanceNode = null;
		
		
		for(Node n: allNodes.values()) {
			int temp = allNodesDistance(n);
			if(minDistace>temp)
			{
				minDistace = temp;
				shortestDistanceNode = n;
				System.out.println(shortestDistanceNode.val);
			}
		}
		
		int maxDistance = Integer.MIN_VALUE;
		for(Node n: shortestDistanceNode.adjNodes.keySet()) {
			int temp = n.adjNodes.get(shortestDistanceNode);
			if(temp>maxDistance)
				maxDistance = temp;
		}
		return maxDistance;
	}


	private int allNodesDistance(Node n) {
		
//		for(Node a: allNodes.values()) {
//			
//			for(Node b: allNodes.values()) {
//				if(a==b)
//					continue;
//				if(!a.adjNodes.containsKey(b))
//				{
//					a.adjNodes.put(b, Integer.MAX_VALUE);
//					b.adjNodes.put(a, Integer.MAX_VALUE);
//				}
//				for(Node c: allNodes.values()) {
//					if(a==c || b==c)
//						continue;
//					if(a.adjNodes.containsKey(c) && c.adjNodes.containsKey(b)) {
//						int distAB = a.adjNodes.get(b);
//						int distAC = a.adjNodes.get(c);
//						int distCB = c.adjNodes.get(b);
//						if (distAB > distAC+distCB)
//						{
//							a.adjNodes.put(b, distAC+distCB);
//							b.adjNodes.put(a, distAC+distCB);
////							System.out.println(distAB+" "+a.adjNodes.get(b));
//						}
//					}
//				}
//			}
//			
//		}
		
//		n.adjNodes.get(n.adjNodes.keys());
//		System.out.println(n.adjNodes.values());
		
		Node g = null;
		for( Node t: n.adjNodes.keySet())
			if(t.val != n.val)
			{
				g = t;
				break;
			}
		
		dfs(n, g, 1);
		
		int sum=0;
		
		for(int t: n.adjNodes.values())
			sum+= t;
		
		return sum;
	}


	private void dfs(Node n, Node t, int dist) {
		for(Node p: t.adjNodes.keySet())
		{
			if (p.val==t.val)
				continue;
			if(!n.adjNodes.containsKey(p))
			{
				n.adjNodes.put(p, dist+1);
				dfs(n, p, dist+1);
			}
		}
	}

}
