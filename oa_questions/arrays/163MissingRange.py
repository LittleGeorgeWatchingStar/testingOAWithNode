class 163MissingRange:
    def findMissingRanges(self, nums: List[int], lower: int, upper: int) -> List[str]:
        output = []

        nums = [lower - 1] + nums + [upper + 1]

        for i in range(len(nums) -1):
            lowerBound = nums[i] + 1
            upperBound = nums[i+1] -1
            if nums[i+1] - nums[i] != 1:
                if lowerBound == upperBound:
                    output.append(f"{lowerBound}")
                else:
                    output.append(f"{lowerBound}->{upperBound}")
        return output

class 163MissingRange:
    def findMissingRanges(self, nums: List[int], lower: int, upper: int) -> List[str]:
        output = []

        nums = nums + [upper + 1]

        previous = lower - 1

        for num in nums:
            if num == previous + 2:
                output.append(f"{previous+1}")
            elif num > previous + 2:
                output.append(f"{previous+1}->{num-1}")

            previous = num

        return output