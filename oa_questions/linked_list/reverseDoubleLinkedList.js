module.exports.reverseDoubleLinkedList = function (llist) {
    // Write your code here
    let tempNode;
    while(llist != null){
        //Swap
        tempNode = llist.next;
        llist.next = llist.prev;
        llist.prev = tempNode;
        //Break if this is last node
        if(llist.prev == null)
            break;
        //Move to next node
        llist = llist.prev;
    }
    return llist;
}