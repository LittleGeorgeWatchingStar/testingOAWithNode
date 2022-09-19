
module.exports.insertNodeAtPosition = function (llist, data, position) {
    // Write your code here
    let addNode = (node, data) => {
        if(node.next == null){
            node.next = new SinglyLinkedListNode(data)
        } else {
            addNode(node.next, data);
        }
        return node;
    }
    let index = 0;
    let current = llist;
    if (position === 0) {
        newNode.next = current;
        addNode(newNode, data);
        return newNode;
    } else {
        let list = new SinglyLinkedListNode(current.data);
        while (current.next) {
            index++;
            if(position === index){
                addNode(list, data);
            } else {
                current = current.next;
                addNode(list, current.data);
            }
        }
        return list;
    }
}

const SinglyLinkedListNode = class {
    constructor(nodeData) {
        this.data = nodeData;
        this.next = null;
    }
};