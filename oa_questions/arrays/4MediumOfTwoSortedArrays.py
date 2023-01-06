# hard
# 4MediumOfTwoSortedArrays
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        copy1, copy2 = nums1, nums2
        total = len(nums1) + len(nums2)
        half = total // 2

        if len(copy2) < len(copy1):
             copy1, copy2 = copy2, copy1
        
        l, r = 0, len(copy1) - 1
        while True:
            i = (l + r) // 2 # index of copy1
            j = half - i - 2 # index of copy2

            oneLeft  = copy1[i] if i >= 0 else float("-infinity")
            oneRight = copy1[i+1] if (i+1) < len(copy1) else float("infinity")
            twoLeft  = copy2[j] if j >= 0 else float("-infinity")
            twoRight = copy2[j+1] if (j+1) < len(copy2) else float("infinity")

            # condition of partition correct
            if oneLeft <= twoRight and twoLeft <= oneRight:
                # odd
                if total % 2:
                    return min(oneRight, twoRight)
                #even
                return (max(oneLeft, twoLeft) + min(oneRight, twoRight)) / 2
            elif oneLeft > twoRight:
                r = i - 1
            else:
                l = i + 1