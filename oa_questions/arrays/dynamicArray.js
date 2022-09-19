
module.exports.dynamicArray = function(n, queries) {
    // Write your code here
    let storeArray = {},
      lastAnswer = 0,
      lastAnswers = [],
      l = queries.length;

    for (let i = 0; i < l; ++i) {
        let [q, x, y] = queries[i],
        index = (x ^ lastAnswer) % n

    if (q == 1) {
      if (storeArray[index])
        storeArray[index].push(y)
      else
        storeArray[index] = [y]

    } else if (q == 2) {
      lastAnswer = storeArray[index][y % storeArray[index].length]
      lastAnswers.push(lastAnswer)
    }
  }

    return lastAnswers;
}