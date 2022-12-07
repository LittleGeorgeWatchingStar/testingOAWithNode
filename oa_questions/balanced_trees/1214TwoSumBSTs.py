# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class 1214TwoSumBSTs:
    def twoSumBSTs(self, root1: Optional[TreeNode], root2: Optional[TreeNode], target: int) -> bool:
        def in_hashset(r):
            return in_hashset(r.left) | {target - r.val} | in_hashset(r.right) if r else set()
        
        def in_check(r):
            return in_check(r.left) or (r.val in s) or in_check(r.right) if r else False

        s = in_hashset(root1)
        return in_check(root2)