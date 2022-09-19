
module.exports.findMergeNode = function (headA, headB) {
    let visitedNodes = new Set();
    let currentNode1 = headA;
    //visit all the nodes in first list
    while(currentNode1 !== null){
        visitedNodes.add(currentNode1);
        currentNode1 = currentNode1.next;
    }
    //go through nodes in second list and 
    //check each one if it was visited already.
    // Visited node is the merge point

    let currentNode2 = headB;
    while(currentNode2 !== null){
        if(visitedNodes.has(currentNode2)){
            return currentNode2.data;
        }
        else{
            visitedNodes.add(currentNode2);
            currentNode2 = currentNode2.next;
        }
    }
    return "Crap something went wrong";
}