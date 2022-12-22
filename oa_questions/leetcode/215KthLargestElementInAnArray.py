class 215KthLargestElementInAnArray:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        nums.sort()

        return nums[len(nums) - k]

class 215withQuickSelect:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        kindex = len(nums) - k

        def quickSelect(l, r):
            pivot, pointer = nums[r], l
            for i in range(l, r):
                if nums[i] <= pivot:
                    nums[pointer], nums[i] = nums[i], nums[pointer]
                    pointer+=1
            nums[pointer], nums[r] = nums[r], nums[pointer]

            if pointer > kindex: return quickSelect(l, pointer - 1)
            elif pointer < kindex: return quickSelect(pointer + 1, r)
            else: return nums[pointer]

        return quickSelect(0, len(nums)-1)