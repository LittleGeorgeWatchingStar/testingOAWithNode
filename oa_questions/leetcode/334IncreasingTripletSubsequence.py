#334IncreasingTripletSubsequence
class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        inf = 10 ** 10
        s1 = s2 = inf

        for i in nums:
            if i > s2:
                return True
            if i > s1:
                s2 = min(i, s2)
            s1 = min(i, s1)
        return False