#938RangeSumOfBST
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        return self.recursive(root, low, high, 0)

    def recursive(self, node, left, right, total):
        if node == None:
            return total
        if left <= node.val <= right:
            total += node.val
            total = self.recursive(node.left, left, right, total)
            total = self.recursive(node.right, left, right, total)

        if node.val < left:
            total = self.recursive(node.right, left, right, total)
        if node.val > right:    
            total = self.recursive(node.left, left, right, total)

        return total