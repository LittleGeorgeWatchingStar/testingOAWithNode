/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
module.exports.intersection_of_2_arrays_349 = function(nums1, nums2) { 
    // Write your code here
    const set1 = new Set(nums1);
    const set2 = new Set(nums2);
    let result = [];
    let maxSet, minSet;
    if (set1.size > set2.size) {
        maxSet = set1;
        minSet = set2;
    } else {
        maxSet = set2;
        minSet = set1;
    }

    for (let value of maxSet) {
        if (minSet.has(value)) {
            result.push(value);
        }
    }
    return result;
  }