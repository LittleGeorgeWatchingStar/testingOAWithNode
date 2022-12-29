#31NextPermutation
class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        pivot = 0

        for i in range(n-1, 0, -1):
            if nums[i-1] < nums[i]:
                pivot = i
                break
        if pivot == 0:
            nums.sort()
            return
        
        # then find the swap which first number > pivot
        swap = n - 1
        while nums[pivot - 1] >= nums[swap]:
            swap -= 1

        # swap
        nums[swap], nums[pivot - 1] = nums[pivot - 1], nums[swap]

        nums[pivot:] = sorted(nums[pivot:])