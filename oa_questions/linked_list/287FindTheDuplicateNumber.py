# 287FindTheDuplicateNumber
# Floyd's Cycle Detection
class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        slow, fast = 0, 0
        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            if slow == fast:
                break

        fromOri = 0
        while True:
            slow = nums[slow]
            fromOri = nums[fromOri]
            if slow == fromOri:
                return slow