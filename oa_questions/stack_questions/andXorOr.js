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
 * Complete the 'andXorOr' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY a as parameter.
 */

function andXorOr(a) {
    // Write your code here
    const stack = [];
    let result = 0;
    for (let i = 0; i < a.length; i++){
        while (stack.length > 0) {
            const top = stack[stack.length - 1];
            const current = a[i] ^ top;
            result = Math.max(result, current);

            if (top > a[i]) {
                stack.pop();
            } else {
                break;
            }   
        }
        stack.push(a[i]);
    }
    return result;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const aCount = parseInt(readLine().trim(), 10);

    const a = readLine().replace(/\s+$/g, '').split(' ').map(aTemp => parseInt(aTemp, 10));

    const result = andXorOr(a);

    ws.write(result + '\n');

    ws.end();
}
