#340LongestSubstringwithAtMostKDistinctCharacters
#sliding window
class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        if len(s) == 0 or k == 0: 
            return 0
        startIdx, endIdx = 0, 0
        seen = dict()
        res = 0

        #expanding the window
        while endIdx < len(s):
            if s[endIdx] not in seen:
                k -= 1
            seen[s[endIdx]] = endIdx

            #shrinking the window
            while k < 0:
                if seen[s[startIdx]] == startIdx:
                    k += 1
                    del seen[s[startIdx]]
                startIdx += 1
            
            res = max(res, endIdx - startIdx + 1)
            endIdx += 1
        return res
