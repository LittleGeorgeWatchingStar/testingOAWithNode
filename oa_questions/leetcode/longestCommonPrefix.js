/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function (strs) {
  if (strs.length === 0) return "";
  let p = strs[0];
  for (let i = 0; i < strs.length; i++) {
    let pre = "";
    for (let s = 0; s < p.length; s++) {
      if (p.charAt(s) === strs[i].charAt(s)) {
        pre += p.charAt(s);
        continue;
      }
      if (s === 0) return "";
      break;
    }
    p = pre;
  }

  return p;
};
