const lib = require('../lib');

describe('absolute', () => {
    test('should return positive if input is positive', () => {
        const result = lib.absolute(1);
        expect(result).toBe(1);
    });
    
    test('should return positive if input is negitive', () => {
        const result = lib.absolute(-1);
        expect(result).toBe(1);
    });
    
    test('should return zero if input is zero', () => {
        const result = lib.absolute(0);
        expect(result).toBe(0);
    });
});

describe('greet', () => {
    it('should return greeting message', () => {
        const result = lib.greet('Steven');
        expect(result).toMatch(/Steven/);
    });
});

