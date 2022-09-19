
module.exports.hasCycle = function (head) {
    // Write your code here
    if(head==null){
        return false;
    } else {
        let slow = head;
	    let fast = head;

	    while (slow !== null && fast !== null && fast.next !== null) {
		    fast = fast.next;
		    fast = fast.next;
            slow = slow.next;

		    if (fast === slow) {
			    return true;
		    }

		
	    }
        return false;
    }
}