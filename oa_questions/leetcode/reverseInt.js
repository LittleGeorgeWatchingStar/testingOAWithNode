/**
 * @param {number} x
 * @return {number}
 */
 var reverse = function(x) {
    let val;
    val= parseInt(x.toString().split('').reverse().join(''));
    if(val > Math.pow(2, 31)){
       return 0;
    }else{
        if(x<0){
           return val*-1;
        }
    }
    return val;
};