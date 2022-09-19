
module.exports.deleteNode = function (llist, position) {
    // Write your code here
    if (llist === null) {
        return null;
    };

    if(position === 0){
        return llist.next;
    };
    llist.next = deleteNode(llist.next, --position);
    return llist;
}
