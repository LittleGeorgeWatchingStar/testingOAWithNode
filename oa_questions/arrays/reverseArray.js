
module.exports.reverseArray = function(a) { 
    // Write your code here
    let result = new Array;
    for(var i = a.length-1; i >= 0; i--) {
        result.push(a[i]);
    }
    return result;
  }