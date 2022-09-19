
module.exports.reversePrint = function (llist) {
    // Write your code here
    let data = [];
    
    while(llist.next){
        data.push(llist.data);
        llist = llist.next;
    }
    data.push(llist.data);
    data.reverse();
    for(const value of data){
        console.log(value);
    }
    return;
}