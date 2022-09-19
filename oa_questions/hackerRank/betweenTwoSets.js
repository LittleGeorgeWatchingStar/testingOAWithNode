function getTotalX(a, b) {
  let n = a.length;
  let m = b.length;

  let results = [];
  for (let i = a[n - 1]; i <= b[0]; i++) {
    if (a.every((x) => isFactor(i, x)) && b.every((x) => isFactor(x, i)))
      results.push(i);
  }

  return results.length;
}
