/*
Part 1 : Spreadsheet cell data

Your goal is to create the foundation for a basic spreadsheet application (eg. Excel, Google Sheets).  Let's assume cells hold numeric values and are referenced by their column (A,B,C,D...) and row (1,2,3,4...). For example, in the spreadsheet below the cell "B3" contains the value 7.

   [A][B][C][D]...
[1]       8
[2] 4
[3]    7
[4]
...

==> Write code that:
 a) Defines a data structure to store the spreadsheet cell data
 b) Provides a getter function to fetch the value of a cell
 c) Provides a setter function to set the value of a cell

------------------------------------------------------------------------------
Part 2 : References

We'd like to add the ability to reference other cells.  For example, in the spreadsheet below cell A4 has the value "=B3".  When our getter fetches the value of cell A4, it should notice this reference and return 7, the value currently in cell B3.

   [A][B][C][D]...
[1]       8
[2] 4
[3]    7
[4]=B3
...

------------------------------------------------------------------------------
Part 3 : Cell addition

Lastly we'd like to be able to calculate the sum of a list of cells. For example, in the spreadsheet below cell D4 has the value "=SUM(A2,C2,B3)". When our getter fetches the value of cell D4, it should return the sum of the values in A2,C2 and B3.

   [A][B][C][D]...
[1]       8
[2] 4     2
[3]    7
[4]          =SUM(A2,C2,B3)
...
*/

const dimension = 4;

var matrix = new Array(dimension);
matrix[0] = new Array(dimension);
matrix[1] = new Array(dimension);
matrix[2] = new Array(dimension);
matrix[3] = new Array(dimension);

matrix[0][0] = "A1";
matrix[1][0] = "A2";
matrix[2][0] = "A3";
matrix[3][0] = "A4";

matrix[0][1] = "B1";
matrix[1][1] = "B2";
matrix[2][1] = "B3";
matrix[3][1] = "B4";

matrix[0][2] = "C1";
matrix[1][2] = "C2";
matrix[2][2] = "C3";
matrix[3][2] = "C4";


matrix[0][3] = "D1";
matrix[1][3] = "D2";
matrix[2][3] = "D3";
matrix[3][3] = "D4";

const m = dimension;
const n = dimension;
var arr = new Array(m); 
for (var i = 0; i < m; i++) {
  arr[i] = new Array(n);
}

function getter(cellName) {
    let result = null;
    for (let i = 0; i < 4; i++) {
        for (let j = 0; j < 4; j++) {
            if (matrix[i][j] == cellName) {
              result = arr[i][j];
            }
        }
    }
    if (typeof result == "number") {
      return result;
    } else if (typeof result == "string" && result.slice(0, 1) == "=") {
      if (result.slice(1, 4) == "SUM") {
        //let numbersOfCell = (result.length - 5)/3;
        let cellNameArr = [];
        let fromPos = 5;
        let toPos = 7;
        while (toPos < result.length) {
          cellNameArr.push(result.slice(fromPos, toPos));
          fromPos += 3;
          toPos += 3;
        }
        return SUM(cellNameArr);
      } else {
        return getter(result.slice(1, 3));
      }
    }
}

function setter(cellName, value) {
    for (let i = 0; i < 4; i++) {
        for (let j = 0; j < 4; j++) {
            if (matrix[i][j] == cellName) {
              arr[i][j] = value;
            }
        }
    }
}

function SUM (cellNameArr) {
    let values = [];
    let finalResult = null;
    cellNameArr.forEach(function(element) { 
      if (typeof element == "string") {
        let result = getter(element);
        if (typeof result == "number") {
          values.push(result);
        }
      }
    });
    if (values.length > 0 ) {
      values.forEach(function(element) { 
        finalResult = finalResult + element;
      });
    }
    return finalResult;
}