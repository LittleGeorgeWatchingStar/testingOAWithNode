const lib = require('../exercise1');

describe('fizzBuzz', () => {
    it('should throw an exception if input is not a number', () => {
        expect(() => {lib.fizzBuzz('a')}).toThrow();
        expect(() => {lib.fizzBuzz(null)}).toThrow();
        expect(() => {lib.fizzBuzz(undefined)}).toThrow();
        expect(() => {lib.fizzBuzz({})}).toThrow();
    });

    it('should return fizzBuzz if input is div by 3 and 5', () => {
        const result = lib.fizzBuzz(15);
        expect(result).toEqual('FizzBuzz');
    });

    it('should return fizz if input is div by 3 not 5', () => {
        const result = lib.fizzBuzz(3);
        expect(result).toEqual('Fizz');
    });
});