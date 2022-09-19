
module.exports.reverse = function (llist) {
    // Write your code here
    let revr = null;
    let curr = llist;
    let next = null;
    while(curr){
        next = curr.next;
        curr.next = revr;
        revr = curr;
        curr = next;
    }
    return revr;
}