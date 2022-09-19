var findMaxConsecutiveOnes = function (nums) {
  let max = 0,
    curr = 0;
  for (let k of nums) {
    max = Math.max(max, (curr += k));
    if (!k) curr = 0;
  }
  return max;
};

var findMaxConsecutiveOnes = function (nums) {
  return nums
    .join("")
    .split("0")
    .reduce((max, ones) => Math.max(max, ones.length), 0);
};

var findMaxConsecutiveOnes = function (nums) {
  return Math.max(
    ...nums
      .join("")
      .split("0")
      .map((ones) => ones.length)
  );
};

var findMaxConsecutiveOnes = function (nums) {
  return Math.max(
    ...(nums.join("").match(/1+/g) || [""]).map((ones) => ones.length)
  );
};
