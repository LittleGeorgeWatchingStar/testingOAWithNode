#454 
#4sum
class Solution:
    def fourSumCount(self, nums1: List[int], nums2: List[int], nums3: List[int], nums4: List[int]) -> int:
        lookup =  collections.Counter()
        res = 0
        for x in nums1:
            for y in nums2:
                lookup[x+y] += 1
        for i in nums3:
            for j in nums4:
                res += lookup[-(i+j)]

        return res
