#324WiggleSortII
class Solution:
    def wiggleSort(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        tmp = sorted(nums)
        mid = len(nums)//2 -1 if len(nums)%2 == 0 else len(nums)//2
        end = len(nums) - 1

        for i in range(0, len(nums)):
            if i % 2 == 0:
                nums[i] = tmp[mid]
                mid-=1
            else:
                nums[i] = tmp[end]
                end-=1

class Solution:
    def wiggleSort(self, nums: List[int]) -> None:
        nums.sort()
        n = len(nums)//2 if len(nums)%2 == 0 else len(nums)//2 + 1
        nums[::2],nums[1::2] = nums[:n][::-1], nums[n:][::-1]