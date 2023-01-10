#76MinimumWindowSubstring
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if t == "": return ""

        countT = {}
        for c in t:
            countT[c] = 1 + countT.get(c, 0)
        window = {}

        have, need = 0, len(countT)
        res, reslen = [-1, -1], float("infinity")
        l = 0
        for r in range(len(s)):
            c = s[r]
            window[c] = 1 + window.get(c, 0)

            if c in countT and window[c] == countT[c]:
                have += 1

            while have == need:
                # update our result
                if (r - l + 1) < reslen:
                    res = [l, r]
                    reslen = (r - l + 1)
                # pop from the left of window
                window[s[l]] -= 1
                if s[l] in countT and window[s[l]] < countT[s[l]]:
                    have -= 1
                l += 1

        return s[res[0]:res[1]+1] 