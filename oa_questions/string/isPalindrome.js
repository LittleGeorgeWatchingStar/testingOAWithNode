function isPalindrom(str) {
    let regexp = /[^A-Za-z0-9]/g;
    // let re = /[\W_]/g;

    let lowRegStr = str.toLowerCase().replace(regexp, '');
    let reverseStr = lowRegStr.split('').reverse().join('');

    return reverseStr === lowRegStr;
}