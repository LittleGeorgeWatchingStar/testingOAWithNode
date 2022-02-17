
module.exports.hourglassSum = function(arr) { 
    // Write your code here
    var max = Number.MIN_SAFE_INTEGER;
    var total = 0;
    for (let i = 0; i < 4; i++) {
        for (let j = 0; j < 4; j++) {
            total = arr[i][j] + arr[i][j+1] + arr[i][j+2]
            + arr[i+1][j+1]
            + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
            max = total > max ? total : max;
        }
    }
    return max;
  }