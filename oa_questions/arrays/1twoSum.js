/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
  for (i = 0; i < nums.length; i++) {
    for (j = 1; j < nums.length; j++) {
      if (i !== j) {
        sum = nums[i] + nums[j];
        if (sum === target) {
          let result = [i, j];
          return result;
        }
      }
    }
  }
};


// two sum map
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
 var twoSum = function(nums, target) {
  const hash = {}; // Stores seen numbers: {seenNumber: indexItOccurred}

  for (let i = 0; i < nums.length; i++) { // loop through all numbers
      const n = nums[i]; // grab the current number `n`.
      if (hash[target - n] !== undefined) { // check if the number we need to add to `n` to reach our target has been seen:
      return [hash[target - n], i]; // grab the index of the seen number, and the index of the current number
      }
      hash[n] = i; // update our hash to include the. number we just saw along with its index.
  }
  return []; // If no numbers add up to equal the `target`, we can return an empty array
}
