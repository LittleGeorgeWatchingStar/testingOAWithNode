#45JumpGame2
class solution:
    def jump(self, nums: List[int]) -> int:
        steps = 0
        l = r = 0

        while r < len(nums) - 1:
            farthest = 0
            for i in range(l, r + 1):
                farthest = max(farthest, i+nums[i])
            l = r + 1
            r = farthest
            steps += 1
        return steps