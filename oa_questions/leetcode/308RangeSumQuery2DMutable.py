#308RangeSumQuery2DMutable
class NumMatrix(object):

    def __init__(self, matrix):
        """
        :type matrix: List[List[int]]
        """
        self.matrix = matrix
        self.prefix_sum = [[0 for i in range(len(matrix[0]))] for j in range(len(matrix))]
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if i == 0:
                    self.prefix_sum[i][j] = matrix[i][j]
                else:
                    self.prefix_sum[i][j] = matrix[i][j] + self.prefix_sum[i-1][j]
        

    def update(self, row, col, val):
        diff = val - self.matrix[row][col]
        self.matrix[row][col] = val 
        for i in range(row, len(self.matrix)):
            self.prefix_sum[i][col] += diff
        

    def sumRegion(self, row1, col1, row2, col2):
        ans = 0
        for j in range(col1, col2+1):
            if row1 > 0:
                ans += (self.prefix_sum[row2][j] - self.prefix_sum[row1-1][j])
            else:
                ans += self.prefix_sum[row2][j]

        return ans
        


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# obj.update(row,col,val)
# param_2 = obj.sumRegion(row1,col1,row2,col2)