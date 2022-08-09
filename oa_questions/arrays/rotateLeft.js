
module.exports.rotateLeft = function (d, arr) {
    // Write your code here
    for (let i = 0; i < d; i++) {
        let removedItem = arr.shift();
        arr.push(removedItem);
    };
    return arr;
}