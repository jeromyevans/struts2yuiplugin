function toRFC3339(dateObject) {
  if(!dateObject){
    dateObject = new Date();
  }
  var formattedDate = [];
  var date = [padString(dateObject.getFullYear(),4), padString(dateObject.getMonth()+1,2), padString(dateObject.getDate(),2)].join('-');
  formattedDate.push(date);
  
  var time = [padString(dateObject.getHours(),2), padString(dateObject.getMinutes(),2), padString(dateObject.getSeconds(),2)].join(':');
  var timezoneOffset = dateObject.getTimezoneOffset();
  time += (timezoneOffset > 0 ? "-" : "+") + 
          padString(Math.floor(Math.abs(timezoneOffset)/60),2) + ":" +
          padString(Math.abs(timezoneOffset)%60,2);
  formattedDate.push(time);
  return formattedDate.join('T'); // String
}

padString = function (str, len, c, dir) {
 var out = String(str);
  if(!c) {
    c = '0';
  }
  if(!dir) {
    dir = 1;
  }
  while(out.length < len) {
    if(dir > 0) {
      out = c + out;
    } else {
      out += c;
    }
  }
  return out;  //  string
}

function updateCal(cal,id) {
  var txtDate = document.getElementById(id);
  
  if (txtDate.value != "") {
    cal.select(txtDate.value);
    
    var firstDate = cal.getSelectedDates()[0];
    cal.cfg.setProperty("pagedate", (firstDate.getMonth()+1) + "/" + firstDate.getFullYear());
    
    cal.render();
  }
}

function showDateValue(target, value) {
  if(target.nodeName.toLowerCase() == "input") {
    target.value = value;
  } else {
    target.innerHTML = value;
  }
}