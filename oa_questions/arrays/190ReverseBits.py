class 190ReverseBits:
    def reverseBits(self, n: int) -> int:
        result = 0
        for i in range(32):
            result <<= 1
            if n&1: result += 1
            n >>= 1
        return result

class 190ReverseBits:
    def reverseBits(self, n: int) -> int:
        result = 0
        for i in range(32):
            bit = (n >> i) & 1
            result = result | bit<<(31-i)
        return result