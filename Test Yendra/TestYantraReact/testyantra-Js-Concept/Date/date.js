var todayDate=new Date();

console.log("Todays Date :"+todayDate);
 

var date =todayDate.getDate();
var month=todayDate.getMonth()+1;
var day=todayDate.getDay()+1;
var year=todayDate.getFullYear();

var display=date+"/"+month+"/"+year;

console.log("Display date :"+display);

months=["Jan","Feb","Mar","Apr","May","June","July","August","Sep","Oct","Nov","Dec"];

var m=todayDate.getMonth();
var m1=months[m];
console.log("Month " +m1);

days=["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];

var d=todayDate.getDay();

console.log("Day "+days[d]);



var dateM= new Date(0);//Milliseconds
console.log("Date with Millisecond constructer :"+dateM);

var dateS=new Date("Octobar 21 2019");
console.log("Date with String :"+dateS);

var dateY=new Date(2019,10);
console.log("Date with year :"+dateY);

