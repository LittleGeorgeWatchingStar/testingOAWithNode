#242ValidAnagram
class solution:
    def isAnagram(self, s: str, t: str) -> bool:
        return sorted(s) == sorted(t)
    
    def are_anagrams(s1, s2):
        if len(s1) != len(s2):
            return False
        return Counter(s1) == Counter(s2)

class solution2:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        counts, countt = {}, {}

        for i in range(len(s)):
            counts[s[i]] = 1 + counts.get(s[i], 0)
            countt[t[i]] = 1 + countt.get(t[i], 0)
        for c in counts:
            if counts[c] != countt.get(c, 0):
                return False
        return True