
module.exports.matchingStrings = function (strings, queries) {
    // Write your code here
    const result = [];
    // Loop over each element in 'queries' array.
    for (let x of queries) {
        // Create counter variable and set it to '0'
        let occurrence = 0;
        // Loop over each element in 'strings' array and compare it         against 'x' using conditional statement
        // for (let i = 0; i < strings.length; i++)
        for (let y of strings) {
            if (y === x) {
            // count the occurrences of y.
            occurrence = occurrence + 1;
        }
    }
    // populate the 'result' array.
    result.push(occurrence);
    }
    return result;
}