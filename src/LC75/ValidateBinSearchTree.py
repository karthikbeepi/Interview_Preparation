# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from typing import Optional
import math
class Solution:
    def are_nodes_within_range(self, root: Optional[TreeNode], minimum: int, maximum: int) -> bool:
        if root is None:
            return True

        if minimum < root.val < maximum:
            return self.are_nodes_within_range(root.left, minimum, root.val) and \
                    self.are_nodes_within_range(root.right, root.val, maximum)
        else:
            return False

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        """
        When thinking of the question in ranges, we see that most of the bin search
        tree validation can be done by adding ranges. 
        i.e. If going to the left of a node, its nodes cannot exceed the node's root value.
        similarly the right. 
        1. Create a helper function that checks if the root values 
            are within ranges. The first call will have inf max and min value. 
        2. THe helper functions can help us verify if the nodes within the node are in range specified. 
        """
        return self.are_nodes_within_range(root, -math.inf, math.inf)