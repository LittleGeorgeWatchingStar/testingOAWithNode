function plusMinus(arr) {
  // Write your code here
  let n = arr.length;
  let pos = 0,
    neg = 0,
    zero = 0;
  for (let i = 0; i < n; i++) {
    if (arr[i] > 0) {
      pos++;
    } else if (arr[i] < 0) {
      neg++;
    } else if (arr[i] === 0) {
      zero++;
    }
  }
  //console.log(n);
  console.log((pos / n).toFixed(6));
  console.log((neg / n).toFixed(6));
  console.log((zero / n).toFixed(6));
}
