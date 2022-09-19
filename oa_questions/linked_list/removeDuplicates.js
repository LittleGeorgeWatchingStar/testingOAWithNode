
module.exports.removeDuplicates = function (llist) {
    // Write your code here
    let currentNode = llist;
    while(currentNode.next!=null){
        let next = currentNode.next;
        
        if(currentNode.data == next.data){
            currentNode.next = next.next;
        }else{
            currentNode = currentNode.next;
        } 
    }
    return llist;
}