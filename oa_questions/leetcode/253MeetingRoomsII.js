/**
 * @param {number[][]} intervals
 * @return {number}
 * 253MeetingRooms2
 */
 var minMeetingRooms = function(intervals) {
    if (intervals.length === 0) {
        return 0;
    }
    
    let pq = new PriorityQueue();
    console.log(intervals);
    intervals.sort(function(a,b){
        return a[0]-b[0];
    });
    console.log(intervals);
    pq.enqueue(intervals[0][1]);
    
    for(let i=1; i < intervals.length ; i++){
        if(intervals[i][0] >= pq.front()){
           pq.dequeue();
        }
        pq.enqueue(intervals[i][1]);
    }
    return pq.size();
};

function PriorityQueue() {
  let collection = [];
  this.enqueue = function(element){
    let added;
    if(this.isEmpty()){
      collection.push(element);
    } else {
      for(let i=0;i<collection.length;i++){
        if(element < collection[i]){
          collection.splice(i,0,element);
          added = true;
          break;
        }
      }
      if(!added) {
        collection.push(element);
      }
    }
  }
  this.dequeue = function() {
    return collection.shift();
  }
  this.front = function() {
    return collection[0];
  }
  this.size = function() {
    return collection.length;
  }
  this.print = function() {
    console.log(collection);
  }
  this.isEmpty = function() {
    return (collection.length===0); 
  }
}