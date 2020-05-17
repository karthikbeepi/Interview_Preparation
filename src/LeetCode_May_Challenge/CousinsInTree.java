package LeetCode_May_Challenge;

public class CousinsInTree {
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
    
    class ParentAndLevel{
        TreeNode parent;
        int level;
        ParentAndLevel(TreeNode t, int i){
            parent = t;
            level = i;
        }
    } 

    public boolean isCousins(TreeNode root, int x, int y) {

        ParentAndLevel forX = dfs(root, 0, x);
        ParentAndLevel forY = dfs(root, 0, y);

        if(forX.level==forY.level && forX.parent != forY.parent){
            return true;
        }
        return false;
    }

    private ParentAndLevel dfs(TreeNode root, int level, int x) {

        if(root == null)
            return null;
        if(root.val == x)
            return new ParentAndLevel(root, level);

        if((root.left!=null && root.left.val == x) || (root.right!=null && root.right.val == x)) 
            return new ParentAndLevel(root, level);

        else {
            ParentAndLevel left = dfs(root.left, level+1, x);
            ParentAndLevel right = dfs(root.right, level+1, x);
            if(left != null)
                return left;
            else if(right != null)
                return right;
            else
                return null;
        }
    }

    public static void main(String[] args) {
        
    }
}