#44WildcardMatchingDP
class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        @cache
        def dp(i, j):
            if j == len(p): return i == len(s)
            elif i == len(s):
                for k in range(j, len(p)):
                    if p[k] != '*': return False
                return True
            
            if s[i] == p[j] or p[j] == '?': return dp(i+1, j+1)
            elif p[j] == '*':
                k = j
                while k < len(p) and p[k] == '*':
                    k += 1
                if k == len(p): return True
                for l in range(i, len(s)):
                    if (s[l] == p[k] or p[k] == '?') and dp(l+1, k+1):
                        return True
                return False
            else:
                return False

        return dp(0,0)