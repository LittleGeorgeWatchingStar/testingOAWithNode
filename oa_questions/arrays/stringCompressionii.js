/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
 var getLengthOfOptimalCompression = function(s, k) {
    const memo = new Map();    
    const state_key = (start,count) => [start, count].toString();
    const range = (start,length) => [...Array(length - start).keys()].map(i => i + start);
    const length = freq => freq > 1  ? freq.toString().length : 0;
    const compressed = freq => 1 + length(freq);
    console.log(compressed);
    const removed = (start, end, dups) => (end - start + 1) - dups;
    console.log(removed);
    const dp = (start, k) => {
        const cur_length = s.length - start;
        if(cur_length === 0 || k >= cur_length) return 0;
        const key = state_key(start, k);
        if(memo.has(key)) return memo.get(key);
        const interval_freqs = new Map();
        let [res, max_freq] = [Infinity, 0];
        for(let compressed_end of range(start, s.length)) {
            const char = s[compressed_end];
            interval_freqs.set(char, (interval_freqs.get(char) || 0) + 1);
            max_freq = Math.max(max_freq, interval_freqs.get(char));
            let next_remove = k - removed(start, compressed_end,max_freq);
            if(next_remove >= 0)
                res = Math.min(res, compressed(max_freq) + dp(compressed_end + 1, next_remove));
        }
        memo.set(key, res);
        return res;
    };
    return dp(0, k);
};