function diagonalDifference(arr) {
  // Write your code here
  let leftDiagnal = 0;
  let rightDiagnal = 0;

  for (let i = 0, j = arr.length - 1; i < arr.length, j >= 0; i++, j--) {
    leftDiagnal = leftDiagnal + arr[i][i];
    rightDiagnal = rightDiagnal + arr[i][j];
  }

  return Math.abs(leftDiagnal - rightDiagnal);
}
