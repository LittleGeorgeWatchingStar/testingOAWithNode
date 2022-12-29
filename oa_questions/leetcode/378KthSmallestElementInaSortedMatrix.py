#378KthSmallestElementInaSortedMatrix
#Binary serach to the right,
# Bisect_right returns the position in the sorted list, 
# where the number passed in argument can be placed so as to maintain 
# the resultant list in sorted order. 
# If the element is already present in the list, the rightmost position
#  where element has to be inserted is returned

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        l, r, N = matrix[0][0], matrix[-1][-1], len(matrix)

        def less_k(m):
            count = 0
            for row in range(N):
                x = bisect.bisect_right(matrix[row],m)
                count += x
            return count

        while l < r:
            mid = (l + r) //2
            if less_k(mid) < k:
                l = mid + 1
            else:
                r = mid
        return l