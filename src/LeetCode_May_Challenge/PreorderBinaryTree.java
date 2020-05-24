package LeetCode_May_Challenge;

public class PreorderBinaryTree {
    public class TreeNode {
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

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = getBST(preorder, 0, preorder.length);
        return root;
    }

    private TreeNode getBST(int[] preorder, int low, int high) {
        
        if(low>=high)
            return null;
        else {
            TreeNode root = new TreeNode(preorder[low]);
            int temp = low+1;
            
            if(low+1>=preorder.length)
                return root;

            while(temp<preorder.length && preorder[low]>=preorder[temp]) {
                temp++;
            }
            root.left = getBST(preorder, low+1, temp);
            root.right = getBST(preorder, temp, high);
            return root;
        }

    }

    private void preorder(TreeNode root) {
        if(root==null)
            return;
        
        preorder(root.left);
        System.out.println(root.val);
        preorder(root.right);
    }

    public static void main(String[] args) {
        PreorderBinaryTree ob = new PreorderBinaryTree();
        ob.preorder(ob.bstFromPreorder(new int[] {8,5,1,7,10,12}));
    }


}