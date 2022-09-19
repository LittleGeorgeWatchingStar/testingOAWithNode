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
 * Complete the 'balancedForest' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY c
 *  2. 2D_INTEGER_ARRAY edges
 */

function balancedForest(c, edges) {
    // Write your code here
    const nodes = c.map(cost => ({ cost, adj: [], visited: false, solved: false }));
    
    for(let [a,b] of edges) {
        nodes[a-1].adj.push(b-1);
        nodes[b-1].adj.push(a-1);
    }
    
    const dfs = n => {
        if (n.visited) return 0;
        n.visited = true;
        
        for (let a of n.adj)
            n.cost += dfs(nodes[a]);
        return n.cost;
    }
    
    const sum = dfs(nodes[0]);
    //console.log(sum, nodes);

    let min = sum;
    const excsum = {};
    const incsum = {};
    
    const solve = n => {
        if (n.solved) return;
        n.solved = true;
        
        const cost_a = 3 * n.cost - sum;
        const cost_b = (sum - n.cost) / 2 - n.cost;
        //console.log("solve", n, { incsum, excsum }, { min, cost_a, cost_b });

        // can split in two equal subtrees?
        if (sum % 2 === 0 && n.cost === (sum / 2)) min = Math.min(min, sum / 2);

        if (cost_a >= 0 && (
            excsum[n.cost] // another subtree with equal cost?
            || excsum[sum - 2 * n.cost] // another subtree with 1/3 cost
            || incsum[sum - n.cost]) // edge to remove
        ) min = Math.min(min, cost_a);

        if (cost_b >= 0 && (sum - n.cost) % 2 === 0) {
            if (excsum[(sum - n.cost) / 2] || incsum[(sum + n.cost) / 2]) 
                min = Math.min(min, cost_b);
        }

        incsum[n.cost] = true;
        for (let a of n.adj) solve(nodes[a]);
        delete incsum[n.cost];
        excsum[n.cost] = true;
    }
    
    solve(nodes[0]);
    return min === sum ? -1 : min;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const q = parseInt(readLine().trim(), 10);

    for (let qItr = 0; qItr < q; qItr++) {
        const n = parseInt(readLine().trim(), 10);

        const c = readLine().replace(/\s+$/g, '').split(' ').map(cTemp => parseInt(cTemp, 10));

        let edges = Array(n - 1);

        for (let i = 0; i < n - 1; i++) {
            edges[i] = readLine().replace(/\s+$/g, '').split(' ').map(edgesTemp => parseInt(edgesTemp, 10));
        }

        const result = balancedForest(c, edges);

        ws.write(result + '\n');
    }

    ws.end();
}
