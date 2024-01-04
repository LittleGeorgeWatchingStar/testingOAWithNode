function isFibonacci(num) {
    let result = isFib(num, 0 ,1);
    if (result) {
        return "yes";
    } else {
        return "no";
    }
}

function isFib(num, a, b) {
    if(num === 0 || num === 1) {
        return true;
    }

    let nextNum = a+b;

    if(nextNum === num) {
        return true;
    } else if (nextNum > num) {
        return false;
    }

    return isFib(num, b, nextNum);
}