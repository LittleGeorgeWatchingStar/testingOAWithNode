#230KthSmallestElementInaBSTIterative
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class solution:
    # iterative
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        n = 0
        stack = []
        cur = root
        res = 0

        while cur or stack:
            while cur:
                stack.append(cur)
                cur = cur.left
            cur = stack.pop()
            n += 1
            if n == k:
                res = cur.val
                break
            cur = cur.right
        return res
    
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        def tree_to_list(root) -> list:
            if not root:
                return []

            return tree_to_list(root.right) + [root.val] + tree_to_list(root.left)
        
        tree_list = tree_to_list(root)
        return tree_list[-k]