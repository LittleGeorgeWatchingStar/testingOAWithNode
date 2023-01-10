#350IntersectionOfTwoArrays2
class solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        counts = collections.Counter(nums2)
        res = []
        
        for num in nums1:
            if counts[num] > 0:
                res.append(num)
                counts[num] -= 1
                
        return res