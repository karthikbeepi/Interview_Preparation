# https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def in_order(self, root: Optional[TreeNode]) -> None:
        if self.cur_k == self.k:
            return
        
        if not root:
            return
        
        self.in_order(root.left)

        self.cur_k += 1

        self.res = root.val

        self.in_order(root.right)



    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        """
        Basic idea: Do an inorder traversal of the BST and stop when you get to k. 
        """

        self.k = k

        self.cur_k = 0

        self.res = -1

        self.in_order(root)

        return self.res