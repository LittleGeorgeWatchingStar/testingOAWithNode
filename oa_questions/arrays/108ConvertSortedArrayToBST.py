# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class 108ConvertSortedArrayToBST:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:

        def buildTree(l, r):
            if l > r:
                return None
            
            m = (l + r) //2
            root = TreeNode(nums[m])
            root.left = buildTree(l, m-1)
            root.right = buildTree(m+1, r)
            return root
        return buildTree(0, len(nums) -1)