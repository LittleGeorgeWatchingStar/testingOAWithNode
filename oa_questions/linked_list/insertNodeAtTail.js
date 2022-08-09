
module.exports.insertNodeAtTail = function (head, data) {
    if(!head){
        return new SinglyLinkedListNode(data);
    }
    if(!head.next){
        head.next = new SinglyLinkedListNode(data);
    } else {
        insertNodeAtTail(head.next, data);
    }

    return head;
}

const SinglyLinkedListNode = class {
    constructor(nodeData) {
        this.data = nodeData;
        this.next = null;
    }
};

const SinglyLinkedList = class {
    constructor() {
        this.head = null;
    }

};