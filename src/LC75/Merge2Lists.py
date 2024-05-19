# Definition for singly-linked list.
from typing import Optional
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        """
        Input: list1 = [1,2,4], list2 = [1,3,4]
        Output: [1,1,2,3,4,4]

        res_list = [dummy, 1, 1, ]
        
        """

        dummy_node = ListNode(val=-777, next=None)

        cur = dummy_node

        if not list1 and not list2:
            return None
        
        if not list1:
            return list2
        
        if not list2:
            return list1

        while list1 and list2:
            if list1.val <= list2.val:
                cur.next = list1
                list1 = list1.next
            else:
                cur.next = list2
                list2 = list2.next
            cur = cur.next
        
        if not list1:
            cur.next = list2

        if not list2:
            cur.next = list1

        return dummy_node.next 
