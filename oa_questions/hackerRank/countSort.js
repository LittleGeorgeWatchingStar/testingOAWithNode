function countSort(arr) {
  // Write your code here
  //let n = parseInt(arr.shift(), 10);
  //console.log(arr);
  let n = arr.length;
  let sorted = [];
  for (let i = 0; i < n; i++) {
    //let space = arr[i].indexOf(' ');
    //console.log(arr[i]);
    let pos = arr[i][0];
    //console.log(arr[i][0]);
    let chars = i < n / 2 ? "-" : arr[i][1];
    sorted[pos] = sorted[pos] || [];
    sorted[pos].push(chars);
  }
  //console.log(sorted);
  let out = [];
  for (let key in sorted) {
    out.push(sorted[key].join(" "));
  }

  console.log(out.join(" "));
}
