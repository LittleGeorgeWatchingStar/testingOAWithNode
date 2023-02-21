#1000MinimumCostToMergeStones
class Solution:
    def mergeStones(self, stones: List[int], k: int) -> int:
        n = len(stones)
        if (n - k) % (k - 1) != 0:
            return -1 

        dp = [[0 for _ in range(n)] for _ in range(n)]

        prefix_sum = [0]
        for i in range(len(stones)):
            prefix_sum.append(prefix_sum[-1] + stones[i])

        for i in range(k-1, n):
            for j in range(n-i):
                minimum = float("inf")
                for s in range(j, j+i, k-1):
                    minimum = min(minimum, dp[j][s] + dp[s+1][j+i])
                dp[j][j+i] = minimum
                if(i) % (k-1) == 0:
                    dp[j][j+i] += prefix_sum[j+i+1] - prefix_sum[j]

        return dp[0][-1]
    
    def mergeStones(self, stones: List[int], k: int) -> int:
        n = len(stones)
        if (n - k) % (k - 1) != 0:
            return -1 

        ans = [0]

        for i in range(n):
            ans.append(ans[-1] + stones[i])

        @lru_cache(None)
        def dfs(lo,hi):
            if hi-lo+1 < k:
                return 0

            res = min(dfs(lo,i) + dfs(i+1,hi) for i in range(lo,hi,k-1))

            if (hi-lo)%(k-1) == 0:
                res += ans[hi+1] - ans[lo]

            return res

        return dfs(0,n-1)