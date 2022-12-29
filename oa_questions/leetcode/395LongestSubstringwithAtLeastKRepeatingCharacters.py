#395LongestSubstringwithAtLeastKRepeatingCharacters
class Solution:
    def longestSubstring(self, s: str, k: int) -> int:
        n = len(s)
        if n == 0 or n < k: return 0
        if k <= 1: return n

        counts = collections.Counter(s)

        d = 0
        while d < n and counts[s[d]] >= k:
            d += 1
        if d >= n-1:
            return d
        
        ls1 = self.longestSubstring(s[0:d], k)

        while d < n and counts[s[d]] < k:
            d += 1
        ls2 = self.longestSubstring(s[d:], k) if d < n else 0
        return max(ls1, ls2)
