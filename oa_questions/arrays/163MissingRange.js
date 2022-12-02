/**
 * @param {number[]} nums
 * @param {number} lower
 * @param {number} upper
 * @return {string[]}
 */
 var findMissingRanges = function(nums, lower, upper) {
    const addRange = (lower, upper) => {
        return `${lower}->${upper}`
    }
    const addNum = n => String(n)
    let output = []

    nums = [lower - 1, ...nums, upper + 1]

    for(let i = 0; i<nums.length-1; i++) {
        const lowerBound = nums[i] + 1
        const upperBound = nums[i+1] -1
        if(nums[i+1] - nums[i] !== 1) {
            if(lowerBound === upperBound) output.push(addNum(lowerBound))
            else output.push(addRange(lowerBound, upperBound))
        }
    }
    return output
};