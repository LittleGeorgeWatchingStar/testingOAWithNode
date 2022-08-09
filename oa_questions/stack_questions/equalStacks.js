function main() {
    var n1_temp = readLine().split(' ');
    var n1 = parseInt(n1_temp[0]);
    var n2 = parseInt(n1_temp[1]);
    var n3 = parseInt(n1_temp[2]);
    h1 = readLine().split(' ');
    h1 = h1.map(Number);
    h2 = readLine().split(' ');
    h2 = h2.map(Number);
    h3 = readLine().split(' ');
    h3 = h3.map(Number);
    
    ///////////
    
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