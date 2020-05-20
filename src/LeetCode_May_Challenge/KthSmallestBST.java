package LeetCode_May_Challenge;

public class KthSmallestBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

    int currentNode = 0;

    public TreeNode inOrder(TreeNode root, int k) {
        if(root==null)
            return null;
        else {
            TreeNode temp = inOrder(root.left, k);
            if(temp!=null)
                return temp;
            currentNode++;
            if(k==currentNode) {
                return root;
            } 
            temp = inOrder(root.right, k);
            if(temp!=null) 
                return temp;
            return null;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        
        return inOrder(root, k).val;

    }
}