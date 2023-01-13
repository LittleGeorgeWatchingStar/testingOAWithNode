#315CountOfSmallerNumbersAfterSelf
from sortedcontainers import SortedList
class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        s = SortedList()
        output = []

        for i in nums[::-1]:
            ans = SortedList.bisect_left(s, i)
            output.append(ans)
            s.add(i)
        return reversed(output)