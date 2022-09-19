
module.exports.sortedInsert = function (llist, data) {
    // Write your code here
    let node = { data, next: null, prev: null }
    if (!llist) return node

    if (data <= llist.data) {
        node.next = llist
        llist.prev = node
        return node
    }

    let  rest = sortedInsert(llist.next, data)
    llist.next = rest
    rest.prev = llist
    return llist
}