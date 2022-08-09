
module.exports.dynamicArray = function (n, queries) {
    // Write your code here
    const arr = Array(n+1).fill(0);
    queries.forEach(rangeSum => {
        let a = rangeSum[0]-1;
        let b = rangeSum[1];
        let k = rangeSum[2];
        arr[a] += k;
        arr[b] -= k;
    })
  
    let sum = 0;
    let maxValue = 0;
  
    for (let i = 0; i<arr.length; i++){
        sum += arr[i];
        maxValue = Math.max(maxValue, sum);
    }
    return maxValue;
}
