class 326PowerOfThree:
    def isPowerOfThree(self, n: int) -> bool:
        if n == 1:
            return True
        elif n <= 2:
            return False

        while n >3:
            if n%3 ==0:
                n/=3
            else:
                return False
        
        if n ==3:
            return True
        else:
            return False