const codingTestofJerrylib = require("../RangeList.js");

describe("unitTestsForJerryQuestion", () => {
  it("should throw an exception if input is not an array of 2 numbers upon add", () => {
    expect(() => {
      codingTestofJerrylib.add("a");
    }).toThrow();
    expect(() => {
      codingTestofJerrylib.add(1);
    }).toThrow();
    expect(() => {
      codingTestofJerrylib.add(null);
    }).toThrow();
    expect(() => {
      codingTestofJerrylib.add(undefined);
    }).toThrow();
    expect(() => {
      codingTestofJerrylib.add();
    }).toThrow();
    expect(() => {
      codingTestofJerrylib.add({});
    }).toThrow();
    expect(() => {
      codingTestofJerrylib.add(["a", "b"]);
    }).toThrow();
  });

  it("should throw an exception if input is not an array of 2 numbers upon remove", () => {
    expect(() => {
      codingTestofJerrylib.add([1, 5]);
      codingTestofJerrylib.remove("a");
    }).toThrow();
    expect(() => {
      codingTestofJerrylib.add([1, 5]);
      codingTestofJerrylib.remove(1);
    }).toThrow();
    expect(() => {
      codingTestofJerrylib.add([1, 5]);
      codingTestofJerrylib.remove(null);
    }).toThrow();
    expect(() => {
      codingTestofJerrylib.add([1, 5]);
      codingTestofJerrylib.remove(undefined);
    }).toThrow();
    expect(() => {
      codingTestofJerrylib.add([1, 5]);
      codingTestofJerrylib.remove();
    }).toThrow();
    expect(() => {
      codingTestofJerrylib.add([1, 5]);
      codingTestofJerrylib.remove({});
    }).toThrow();
    expect(() => {
      codingTestofJerrylib.add([1, 5]);
      codingTestofJerrylib.remove(["a", "b"]);
    }).toThrow();
  });

  it("should return a string which is formatted from the ranges array", () => {
    const result = codingTestofJerrylib.add([1, 5]);
    expect(result).toEqual("[1, 5)");
  });

  it("should return a continuous array of range when add 2 overlapping ranges", () => {
    codingTestofJerrylib.add([1, 5]);
    const result = codingTestofJerrylib.add([4, 10]);
    expect(result).toEqual("[1, 10)");
  });

  it("should return 2 subRanges when removing a subRange in the middle", () => {
    codingTestofJerrylib.add([1, 5]);
    codingTestofJerrylib.add([4, 10]);
    const result = codingTestofJerrylib.remove([4, 6]);
    expect(result).toEqual("[1, 4) [6, 10)");
  });
});
