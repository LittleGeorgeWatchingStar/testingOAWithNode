// var stack = [];
// stack.push(2);       // stack is now [2]
// stack.push(5);       // stack is now [2, 5]
// var i = stack.pop(); // stack is now [2]
// alert(i);            // displays 5

// var queue = [];
// queue.push(2);         // queue is now [2]
// queue.push(5);         // queue is now [2, 5]
// var i = queue.shift(); // queue is now [5]
// alert(i);              // displays 2

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
 * Complete the 'getMax' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts STRING_ARRAY operations as parameter.
 */

function getMax(operations) {
    // Write your code here
    
    let results = [];
  
    let stack = [0];
    for (let i of operations) {
        let [cmd, param] = i.split(' ').map(o => parseInt(o) );
    
        let max = stack[stack.length-1]; // top of stack i.e. peek()
        switch (cmd) {
            case 1:  stack.push((param > max) ? param : max); break;
            case 2: stack.pop(); break;
            case 3: results.push(max); break;
        }
    }
    return results;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const n = parseInt(readLine().trim(), 10);

    let ops = [];

    for (let i = 0; i < n; i++) {
        const opsItem = readLine();
        ops.push(opsItem);
    }

    const res = getMax(ops);

    ws.write(res.join('\n') + '\n');

    ws.end();
}
