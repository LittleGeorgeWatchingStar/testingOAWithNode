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
