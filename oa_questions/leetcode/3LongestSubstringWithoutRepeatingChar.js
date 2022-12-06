/**
 * @param {string} s
 * @return {number}
 */
 var lengthOfLongestSubstring = function(s) {
    let tracker = new Map()
    let left = 0
    let right = 0
    let max = 0
    while (right < s.length) {
        if (!tracker.has(s[right])) {
            tracker.set(s[right], s[right])
            right +=1
            max = Math.max(max, right - left )

        } else {
            tracker.delete(s[left])
            left +=1
        }        
    }
    return max
};

/**
 * @param {string} s
 * @return {number}
 */
 var lengthOfLongestSubstring = function(s) {
    let array = s.split("");
    
    let newMap = new Map();
    
    let lengthString = 0;
    let lengthOfLongestStr = 0;
    let start = 0;
    
    for (let index = 0; index < array.length; index++) {
        const element = array[index];
        if (newMap.get(element)) {
            newMap.set(element, newMap.get(element) + 1);
        } else {
            newMap.set(element, 1);
        }
        if (newMap.size === index - start + 1) {
            lengthString = index - start + 1;
            if (lengthString > lengthOfLongestStr) {
                lengthOfLongestStr = lengthString;
            }
        }
        if (newMap.size < index - start + 1) {
            while (newMap.size < index - start + 1) {
                newMap.set(array[start], newMap.get(array[start]) - 1);
                if (newMap.get(array[start]) === 0) {
                    newMap.delete(array[start]);
                }
                start++;
            }
        }
    }
    return lengthOfLongestStr;
};