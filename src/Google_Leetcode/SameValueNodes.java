package Google_Leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Node{
	int val;
	Node left, right;
	public Node(int i) {
		val = i;
		left = right = null;
	}
}

class Count{
	int c=0;
}

public class SameValueNodes {
	
	Node root;
	
	public int minHeightOfTree(Node n) {
		if(n==null)
			return 0;
		int leftHeight = minHeightOfTree(n.left);
		int rightHeight = minHeightOfTree(n.right);
		if(leftHeight<=rightHeight)
			return 1 + leftHeight;
		else
			return 1 + rightHeight;
	}
	
	public void add(int i, Node n) {
		if(n==null)
			return; 
		if(n.left==null) {
			n.left = new Node(i);
			return;
		}
		if(n.right==null) {
			n.right = new Node(i);
			return;
		}
		int leftHeight = minHeightOfTree(n.left);
		int rightHeight = minHeightOfTree(n.right);
		if (leftHeight<=rightHeight) {
			add(i, n.left);
			return;
		} else {
			add(i, n.right);
		}
	}
	
	public void printBFS(Node r) {
		ArrayList<Node> queue = new ArrayList<Node>();
		queue.add(r);
		while(!queue.isEmpty()) {
			Node front = queue.get(0);
			queue.remove(0);
			System.out.print(front.val+" ");
			if (front.left!=null)
				queue.add(front.left);
			if (front.right!=null)
				queue.add(front.right);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		SameValueNodes obj = new SameValueNodes();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int height = Integer.parseInt(br.readLine());
		obj.root = new Node(Integer.parseInt(br.readLine()));
		for(int i=1; i<=height; i++) {
			String[] temp = br.readLine().split(" ");
			for(String s: temp)
				obj.add(Integer.parseInt(s), obj.root);
		}
		obj.countSubTrees();
		
	}

	private void countSubTrees() {
		
		Count c = new Count();
		countSubTrees(root, c);
		System.out.println(c.c);
		
	}

	private boolean countSubTrees(Node r, Count count) {
		
		if (r == null)
			return true;
		
		// Recursively count in left and right subtrees also 
        boolean left = countSubTrees(r.left, count); 
        boolean right = countSubTrees(r.right, count); 
   
        // If any of the subtrees is not singly, then this 
        // cannot be singly. 
        if (left == false || right == false) 
            return false; 
   
        // If left subtree is singly and non-empty, but data 
        // doesn't match 
        if (r.left != null && r.val != r.left.val) 
            return false; 
   
        // Same for right subtree 
        if (r.right != null && r.val != r.right.val) 
            return false; 
   
        // If none of the above conditions is true, then 
        // tree rooted under root is single valued, increment 
        // count and return true. 
        count.c++; 
        return true; 
		
	}

}
