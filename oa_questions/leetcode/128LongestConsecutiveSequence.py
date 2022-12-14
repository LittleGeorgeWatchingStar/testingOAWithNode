class 128LongestConsecutiveSequence:
    def longestConsecutive(self, nums: List[int]) -> int:
        numSet = set(nums)
        longest = 0

        for n in nums:
            #check if it's the start of a sequence:
            if (n - 1) not in numSet:
                start = n
                
                while start in numSet:
                    start += 1
                longest = max(longest, start - n )
            return longest

class 128LongestConsecutiveSequence:
    def longestConsecutive(self, nums: List[int]) -> int:
        numset = set(nums)
        longest = 0

        for n in nums:
            #check if it's the start of a sequence:
            prev = n - 1
            if prev not in numset:
                length = 0
                
                while (n + length) in numset:
                    length += 1
                longest = max(length, longest)
            return longest