
module.exports.insertNodeAtHead = function (head, data) {
    if(!head){
        return new SinglyLinkedListNode(data);
    } else {
        let node = new SinglyLinkedListNode(data);
        node.next = head;
        return node;
    }
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