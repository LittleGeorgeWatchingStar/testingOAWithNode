class 2357MakeArrayZero:
    def minimumOperations(self, nums: List[int]) -> int:
        return len(set([num for num in nums if num > 0]))

class 2357MakeArrayZero:
    def minimumOperations(self, nums: List[int]) -> int:
        return len(set(nums)) - nums.count(0)