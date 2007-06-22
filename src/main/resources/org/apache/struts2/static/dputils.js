var s2yui = YAHOO.namespace("s2yui");
YAHOO.namespace("s2yui.i18n");

YAHOO.s2yui.toRFC3339 = function(dateObject) {
  if(!dateObject){
    dateObject = new Date();
  }
  var formattedDate = [];
  var date = [this.padString(dateObject.getFullYear(),4), this.padString(dateObject.getMonth()+1,2), this.padString(dateObject.getDate(),2)].join('-');
  formattedDate.push(date);
  
  var time = [this.padString(dateObject.getHours(),2), this.padString(dateObject.getMinutes(),2), this.padString(dateObject.getSeconds(),2)].join(':');
  var timezoneOffset = dateObject.getTimezoneOffset();
  time += (timezoneOffset > 0 ? "-" : "+") + 
          this.padString(Math.floor(Math.abs(timezoneOffset)/60),2) + ":" +
          this.padString(Math.abs(timezoneOffset)%60,2);
  formattedDate.push(time);
  return formattedDate.join('T'); // String
};

YAHOO.s2yui.padString = function (str, len, c, dir) {
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
};

YAHOO.s2yui.showDateValue = function(target, value) {
  if(target.nodeName.toLowerCase() == "input") {
    target.value = value;
  } else {
    target.innerHTML = value;
  }
};

YAHOO.s2yui.loadLanguageStrings = function(dp, langName) {
  var lang = YAHOO.s2yui.i18n[langName];
  if(!lang) {
    YAHOO.log("Language " + langName + " is not available");
    return;
  } else {
    dp.cfg.setProperty("MONTHS_SHORT", lang.months_short);
    dp.cfg.setProperty("MONTHS_LONG", lang.months_long);
    dp.cfg.setProperty("WEEKDAYS_SHORT", lang.weekdays_short);
    dp.cfg.setProperty("WEEKDAYS_LONG", lang.weekdays_long );
  }
};