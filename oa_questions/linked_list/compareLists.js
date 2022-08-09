
module.exports.compareLists = function (llist1, llist2) {
    while(llist1.next){
        if(llist1.data !== llist2.data){
            return 0;
        }
        llist1 = llist1.next;
        llist2 = llist2.next;
    }
    if(llist1 && llist2){
        if(llist1.data !== llist2.data){
            return 0;
        } else {
            return 1;
        }
    } else {
        if(llist1 !== llist2){
            return 0;
        } else {
            return 1;
        }
    }
}