
module.exports.getNode = function (llist, positionFromTail) {
    // Write your code here
    let count = 0;   
    let currentNode = llist;
    while(currentNode != null){
        currentNode = currentNode.next;
        count++;
    }    
    
    let reqNode = count - positionFromTail;
    let i=1;
    while(i!=(reqNode)){
        llist = llist.next;
        i++;
    }
    return llist.data;
}