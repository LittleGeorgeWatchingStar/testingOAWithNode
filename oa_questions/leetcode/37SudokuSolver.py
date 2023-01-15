#37SudokuSolver
class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        rows = [set() for i in range(9)]
        cols = [set() for i in range(9)]
        boxes = [set() for i in range(9)]

        for i in range(9):
            for j in range(9):
                if board[i][j] != ".":
                    num = int(board[i][j])
                    rows[i].add(num)
                    cols[j].add(num)
                    box_id = i//3*3 + j//3
                    boxes[box_id].add(num)
        
        def backTrack(i,j):
            nonlocal solved
            if i == 9:
                solved = True
                return
            newi = i + (j+1)//9
            newj = (j+1)%9

            if board[i][j] != ".":
                backTrack(newi,newj)
            else:
                for num in range(1, 10):
                   box_id = i//3*3 + j//3
                   if num not in rows[i] and num not in cols[j] and num not in boxes[box_id]:
                       rows[i].add(num)
                       cols[j].add(num)
                       boxes[box_id].add(num)
                       board[i][j] = str(num)
                       backTrack(newi, newj)

                       if not solved:
                           rows[i].remove(num)
                           cols[j].remove(num)
                           boxes[box_id].remove(num)
                           board[i][j] = "."
        solved = False
        backTrack(0,0)


