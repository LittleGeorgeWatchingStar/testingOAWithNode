/**
 *
 * NOTE: Feel free to add any extra member variables/functions you like.
 */
class RangeList {
  constructor() {
    this.ranges = [];
  }

  /**
  * Adds a range to the list
  * @param {Array<number>} range - Array of two integers that specify
  beginning and end of range.
  */
  add(range) {
    if (range != null && range.length == 2) {
      const left = range[0],
        right = range[1];
      if (typeof left === "number" && typeof left === "number") {
        let subRange = [left, right];
        let i = 0;
        // pointer moves to the next, try to locate the place to insert
        while (i < this.ranges.length && this.ranges[i][1] < subRange[0]) {
          i++;
        }
        // delete the subRange at the position first before merging
        while (i < this.ranges.length && this.ranges[i][0] <= subRange[1]) {
          subRange = [
            Math.min(subRange[0], this.ranges[i][0]),
            Math.max(subRange[1], this.ranges[i][1]),
          ];
          this.ranges.splice(i, 1);
        }
        // add the union of interval
        this.ranges.splice(i, 0, subRange);
      } else {
        throw "Should input integers";
      }
    } else {
      throw "Unsupported param";
    }
  }

  /**
  * Removes a range from the list
  * @param {Array<number>} range - Array of two integers that specify
  beginning and end of range.
  */
  remove(range) {
    if (range != null && range.length === 2) {
      const left = range[0],
        right = range[1];
      if (typeof left === "number" && typeof left === "number") {
        let i = 0;
        while (i < this.ranges.length && this.ranges[i][1] < left) {
          i++;
        }
        // the subRange to delete is between one of the subRanges
        if (i < this.ranges.length && this.ranges[i][0] < left) {
          let subRangeBefore = [this.ranges[i][0], left];
          if (right < this.ranges[i][1]) {
            let subRangeAfter = [right, this.ranges[i][1]];
            this.ranges.splice(i, 1, subRangeBefore, subRangeAfter);
            return;
          }
          this.ranges.splice(i, 1, subRangeBefore);
          i++;
        }
        // remove the subRange at that position
        if (i < this.ranges.length && right >= this.ranges[i][1]) {
          this.ranges.splice(i, 1);
        }
        // update subRange and insert it
        if (i < this.ranges.length && right > this.ranges[i][0]) {
          let subRangeAfter = [right, this.ranges[i][1]];
          this.ranges.splice(i, 1, subRangeAfter);
        }
      } else {
        throw "Should input integers";
      }
    } else {
      throw "Unsupported param";
    }
  }

  /**
   * Prints out the list of ranges in the range list
   * @returns {String} - String representation of ranges
   */
  print() {
    var stringOutput = this.ranges
      .map((i) => "[" + i[0] + ", " + i[1] + ")")
      .join(" ");
    console.log(stringOutput);
  }
}

// Execute these code to run
// const rl = new RangeList();
// rl.add([1, 5]);
// rl.add([10, 20]);
// rl.add([20, 20]);
// rl.add([20, 21]);
// rl.add([2, 4]);
// rl.add([3, 8]);
// rl.remove([10, 10]);
// rl.remove([10, 11]);
// rl.remove([15, 17]);
// rl.remove([3, 19]);
// rl.print();
