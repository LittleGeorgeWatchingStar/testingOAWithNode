const a=[1,2,[3],4,5];

// implement this
// a.multiply()
// console.log(a) // [1, 2, [3], 4, 5, 1, 4, [3, 9], 16, 25]

function multiply() {
    let multipliedArr = a.map(function (i) {
        if (typeof i  === 'number') {
            i = i*i;
        } else if (Array.isArrray(i)) {
            let buffer = i.map(j => j*j);
            i.concat(buffer);
        }
    });
    a.concat(multipliedArr);
}

a.multiply();
console.log(a);