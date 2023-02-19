#515FindLargestValueInEachTreeRow
# Definition for a binary tree node.
# bfs
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []

        largestValues = []
        queue = collections.deque([root])

        while queue:
            maxSoFar = float('-inf')

            for _ in range(len(queue)):
                top = queue.popleft()
                maxSoFar = max(maxSoFar, top.val)

                if top.left:
                    queue.append(top.left)

                if top.right:
                    queue.append(top.right)

            largestValues.append(maxSoFar)

        return largestValues