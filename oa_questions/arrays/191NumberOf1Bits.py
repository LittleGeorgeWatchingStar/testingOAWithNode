class 191NumberOf1Bits:
    def hammingWeight(self, n: int) -> int:
        res = 0
        while n:
            res += n &1
            n >>=1
        return res

class 191NumberOf1Bits:
    def hammingWeight(self, n: int) -> int:
        res = 0
        
        while n:
            n = n&(n-1)
            res += 1


        return res