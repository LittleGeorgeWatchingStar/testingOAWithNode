#29DivideTwoIntegers
class solution:
    def divide(self, dividend: int, divisor: int) -> int:
        positive = (dividend < 0) is (divisor < 0)
        dividend, divisor = abs(dividend), abs(divisor)
        res = 0
        if dividend < divisor:
            return 0
        else:
            while dividend >= divisor:
                temp = divisor
                multi = 1
                while dividend >= temp:
                    dividend -= temp
                    res += multi
                    multi += multi
                    temp += temp

        if not positive:
            res = -res
        return min(max(-2147483648, res), 2147483647)