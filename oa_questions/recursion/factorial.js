function factorial(num) {
    let result = 0;

    if (num === 1) {
        result = 1
    } else {
        result = num * factorial(num-1)
    }

    return result;
}