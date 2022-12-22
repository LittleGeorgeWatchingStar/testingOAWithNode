class 204CountPrimes:
    def countPrimes(self, n: int) -> int:
        if n <= 1:
            return 0

        nums = [None]*n
        nums[0] = False
        nums[1] = False

        for i in range(n):
            if nums[i] == None:
                nums[i] = True

                for j in range(i*i, n, i):
                    nums[j] = False
        return sum(nums)

