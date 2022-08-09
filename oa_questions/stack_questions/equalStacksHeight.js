'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function(inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function() {
    inputString = inputString.split('\n');

    main();
});

function readLine() {
    return inputString[currentLine++];
}

/*
 * Complete the 'equalStacks' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY h1
 *  2. INTEGER_ARRAY h2
 *  3. INTEGER_ARRAY h3
 */

function equalStacks(h1, h2, h3) {
    // Write your code here
    var arrStack = [h1, h2, h3];
    var arrTopPointer = [0, 0, 0];
    var arrSum = [getHeight(h1), getHeight(h2), getHeight(h3)];

    var index = getMaxStackIndex(arrSum);
    while (index >= 0) {        
        arrSum[index] -= arrStack[index][arrTopPointer[index]];
        arrTopPointer[index]++;
        index = getMaxStackIndex(arrSum);
    }
    return arrSum[0];
}

function getMaxStackIndex(arrSum) {
    var hasMax = false;
    var maxVal = arrSum[0];
    var maxIndex = 0;
    for (var i = 1; i < arrSum.length; i++) {
        if (arrSum[i] > maxVal) {
            hasMax = true;
            maxVal = arrSum[i];
            maxIndex = i;
        } else if ((arrSum[i] < maxVal)) {
            hasMax = true;
        }
    }
    if (hasMax) {
        return maxIndex;
    } else {
        return -1;
    }
}

function getHeight(stack) {
    var sum = 0;
    for (var i = 0; i < stack.length; i++) {
        sum += stack[i];
    }
    return sum;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const firstMultipleInput = readLine().replace(/\s+$/g, '').split(' ');

    const n1 = parseInt(firstMultipleInput[0], 10);

    const n2 = parseInt(firstMultipleInput[1], 10);

    const n3 = parseInt(firstMultipleInput[2], 10);

    const h1 = readLine().replace(/\s+$/g, '').split(' ').map(h1Temp => parseInt(h1Temp, 10));

    const h2 = readLine().replace(/\s+$/g, '').split(' ').map(h2Temp => parseInt(h2Temp, 10));

    const h3 = readLine().replace(/\s+$/g, '').split(' ').map(h3Temp => parseInt(h3Temp, 10));

    const result = equalStacks(h1, h2, h3);

    ws.write(result + '\n');

    ws.end();
}
