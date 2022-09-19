function miniMaxSum(arr) {
  // Write your code here
  var max = -Infinity;
  var min = Infinity;
  for (var i = 0; i < arr.length; i++) {
    var sum = 0;
    for (var j = 0; j < arr.length; j++) {
      if (i != j) {
        sum += arr[j];
      }
    }
    if (sum < min) min = sum;
    if (sum > max) max = sum;
  }
  console.log(min, max);
}
