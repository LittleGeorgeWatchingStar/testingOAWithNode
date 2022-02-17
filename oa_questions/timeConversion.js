
module.exports.timeConversion = function(s) { 
    // Write your code here
    let AMPM = s.slice(-2);
    let timeArr = s.slice(0, -2).split(":");
    
    if(AMPM === "AM" && timeArr[0] === "12"){
        timeArr[0] = "00";        
    } else if (AMPM === "PM") {
        timeArr[0] = (timeArr[0] %12) + 12;
    }
        
    return timeArr.join(":");
  }