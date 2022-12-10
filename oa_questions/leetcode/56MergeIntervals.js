/**
 * @param {number[][]} intervals
 * @return {number[][]}
 * 56MergeIntervals
 */
 var merge = function(intervals) {
    if (intervals.length <= 1) return intervals;
    
    intervals.sort((a, b) => a[0] - b[0]);// O(nlog(n)) Time(giving upper bound)
    
    const merged = [intervals[0]];
    for (let i = 1; i < intervals.length; i++) {
        const lastIdxOfMerged = merged.length - 1;
        if (merged[lastIdxOfMerged][1] >= intervals[i][0]) {
            doMerge(lastIdxOfMerged, i, merged, intervals);
        } else {
            merged.push(intervals[i]);
        }
    }
    
    return merged;
};

function doMerge(j, i, merged, intervals) {
    merged[j][0] = Math.min(merged[j][0], intervals[i][0]);
    merged[j][1] = Math.max(merged[j][1], intervals[i][1]);
    
}