function swap(arr, index) {
    let temp = arr[index];
    arr[index] = arr[index + 2];
    arr[index + 2] = temp;
    return arr;
}

function swapBack(str, index) {
    let arr = str.split('');
    return swap(arr, index).join('');
}

function twins(a, b) {
// Write your code here
let result = Array(a.length);

for (let i = 0; i < a.length; i++) {
    if (!b[i]) {
        break;
    } else if (a[i] === b[i]) {
                   result[i] = "Yes";
       continue;
    }
    
    let verification = [];
    verification.push(a[i]);
    
    for (let k = 0; k < verification.length; k++) {
        var str = verification[k],
              txtArr = str.split('');

      for (var j = 0; j < txtArr.length; j++) {
          if (!txtArr[j+2]) {
              break;
          }

          swap(txtArr, j);

          var check = txtArr.join('');
          if (check === b[i]) {
            result[i] = "Yes";
            break;
          }
          else {
              var checkBack = swapBack(check, j);
              if (verification.indexOf(check) === -1) {
                verification.push(check);
            }
              if (verification.indexOf(checkBack) === -1) {
                verification.push(checkBack);
             }
          }
      }
      !result[i] && (result[i] = "No");
    }
}
return result;
}