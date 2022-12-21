class 166FractionToRecurringDecimal:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        negativeFlag = numerator * denominator < 0
        numerator = abs(numerator)
        denominator = abs(denominator)

        numList = []
        counter = 0
        loopDict = dict()
        loopStr = None

        while True:
            numList.append(str(numerator // denominator))
            counter += 1
            numerator = 10 * (numerator % denominator)
            if numerator == 0:
                break
            firstLoc = loopDict.get(numerator)
            if firstLoc:
                loopStr = "".join(numList[firstLoc:counter])
                break
            loopDict[numerator] = counter

        ans = numList[0]

        if len(numList) > 1:
            ans += "."

        if loopStr:
            ans += "".join(numList[1: len(numList) - len(loopStr)]) + "(" + loopStr + ")"
        else:
            ans += "".join(numList[1:])

        if negativeFlag:
            ans = "-" + ans

        return ans