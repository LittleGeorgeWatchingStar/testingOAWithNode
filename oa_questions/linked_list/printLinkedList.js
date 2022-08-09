
module.exports.printLinkedList = function (head) {
    while(head != null){
        console.log(head.data)
        head = head.next
    }
}