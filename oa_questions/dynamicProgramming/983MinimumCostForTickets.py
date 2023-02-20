#983MinimumCostForTickets
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        n = len(days)
        dp = [365*costs[0]] * (n+1)
        dp[n] = 0
        
        for i in range(n-1, -1, -1):
            d7, d30 = i, i
            while d7 < n and days[d7] < days[i] + 7: 
                d7 += 1
            while d30 < n and days[d30] < days[i] + 30: 
                d30 += 1
            dp[i] = min(costs[0] + dp[i+1], costs[1] + dp[d7], costs[2] + dp[d30])
        
        return dp[0]
    
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp = {}

        def dfs(i):
            if i == len(days):
                return 0
            if i in dp:
                return dp[i]
            
            dp[i] = float("inf")
            for d, c in zip([1, 7, 30], costs):
                j = i
                while j < len(days) and days[j] < days[i] + d:
                    j+=1
                dp[i] = min(dp[i], c + dfs(j))
            return dp[i]
        return dfs(0)