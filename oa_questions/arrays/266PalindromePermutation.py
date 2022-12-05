class Solution:
    def canPermutePalindrome(self, s: str) -> bool:
        if len(s) == 0:
            return True

        dict = {}
        count = 0
        for ch in s:
            if ch not in dict:
                dict[ch] = 0
            dict[ch] += 1
        
            if dict[ch] % 2 == 0:
                count -= 1
            else:
                count += 1
        return count < 2