#348DesignTic-Tac-Toe
class TicTacToe:

    def __init__(self, n: int):
        self.rows = [ 0 for i in range(n) ]
        self.cols = [ 0 for i in range(n) ]
        self.diag=0
        self.antiDiag=0
        self.n=n
        

    def move(self, row: int, col: int, player: int) -> int:
        needed=self.n
        if player == 1:
            self.rows[row]+=1
            if self.rows[row]==needed: return player
        
            self.cols[col]+=1
            if self.cols[col]==needed: return player
        
            if row==col:
                self.diag+=1
            if self.diag==needed: return player
          
            if row+col==self.n-1:
                self.antiDiag+=1
            if self.antiDiag==needed: return player
          
        if player == 2:
            self.rows[row]-=1
            if self.rows[row]==-needed: return player
        
            self.cols[col]-=1
            if self.cols[col]==-needed: return player
        
            if row==col:
                self.diag-=1
            if self.diag==-needed: return player
          
            if row+col==self.n-1:
                self.antiDiag-=1
            if self.antiDiag==-needed: return player
          
        return 0
        


# Your TicTacToe object will be instantiated and called as such:
# obj = TicTacToe(n)
# param_1 = obj.move(row,col,player)