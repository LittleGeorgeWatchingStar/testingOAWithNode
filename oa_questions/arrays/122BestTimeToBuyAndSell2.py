class 122BestTimeToBuyAndSell2:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0

        for i in range(1, len(prices)):
            temp = prices[i] - prices[i - 1]
            if temp > 0:
                profit += temp

        return profit