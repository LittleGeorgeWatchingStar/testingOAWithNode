class Solution:
    def firstUniqChar(self, s: str) -> int:
        lookup = collections.Counter(s)

        for i, c in enumerate(s):
            if lookup[c] == 1:
                return i
        return -1

class Solution:
    def firstUniqChar(self, s: str) -> int:
        lookup = dict()
        for i in s:
            if i in lookup:
                lookup[i] +=1
            else:
                lookup[i] = 1

        for i, c in enumerate(s):
            if lookup[c] == 1:
                return i
        return -1