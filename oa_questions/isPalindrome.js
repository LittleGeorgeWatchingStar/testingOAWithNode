/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function (x) {
  let k = x.toString();
  // Step 1. Use the split() method to return a new array
  var splitString = k.split("");

  // Step 2. Use the reverse() method to reverse the new created array
  var reverseArray = splitString.reverse();

  // Step 3. Use the join() method to join all elements of the array into a string
  var joinArray = reverseArray.join("");

  return k === joinArray;
};
