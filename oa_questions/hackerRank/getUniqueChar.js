/*
 * Complete the 'getUniqueCharacter' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts STRING s as parameter.
 */

function getUniqueCharacter(s) {
    // Write your code here
    
    let map = new Map();
    
    let uniquearr = [];
    let posMap = new Map();
    
    const arr = s.split("");
    
    for (let i = 0; i < arr.length; i++) {
        if(!map.has(arr[i])) {
            map.set(arr[i], 1);
        } else {
            let curr = map.get(arr[i]);
            curr++;
            map.set(arr[i], curr);
        }
    }
    
    for (const [key, value] of map) {
        if(value == 1){
            uniquearr.push(key);
        }
    }
    
    for (let i = 0; i < uniquearr.length; i++) {
        let pos = arr.indexOf(uniquearr[i]);
        posMap.set(uniquearr[i], pos);
    }
    
    let min = arr.length+1;
    for (const value of posMap.values()) {
        if (value < min) {
            min = value;
        }
    }
    
    if(min == arr.length+1) {
        return -1;
    } else {
        return min+1;
    }
}