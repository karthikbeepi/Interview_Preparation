package Trees_and_graphs;

import java.util.ArrayList;

public class BTree {
	
	BTreeNode root;
	
	public BTree(int val) {
		
		root = new BTreeNode(val);
		
	}

	public void add(int val) {
		
		BTreeNode cur = root;
		
		while(true) {
			if(cur.val >= val ) {
				if (cur.left!=null) {
					cur = cur.left;
					continue;
				} else {
					cur.left = new BTreeNode(val);
					break;
				}
				
			}
			else if(cur.val < val) {
				if(cur.right!=null) {
					cur = cur.right;
					continue;
				} else {
					cur.right = new BTreeNode(val);
					break;
				}
			}
		}
		
	}
	
	public void print() {
		ArrayList<BTreeNode> queue = new ArrayList<BTreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BTreeNode front = queue.get(0);
			queue.remove(0);
			if(front.left!=null)
				queue.add(front.left);
			if(front.right!=null)
				queue.add(front.right);
			System.out.print(front.val+" ");
		}
		System.out.println();
	}	
	public void printDFS(BTreeNode root) {
		
		if(root==null)
			return;
		printDFS(root.left);
		System.out.print(root.val+" ");
		printDFS(root.right);
	}
	
	public static void main(String args[]) {
		BTree obj = new BTree(5);
		obj.add(3);
		obj.add(6);
		obj.add(52);
		obj.add(2);
		obj.add(1);
		obj.print();
		obj.printDFS(obj.root);
	}
}
