var hobbies=["football","Badminton","Cooking","Singing","traveling"]
hobbies.push("Reading","Coding")

console.log("hobbies after push"+hobbies);
console.log("-------------------");

hobbies.pop()
console.log("hobbies after pop",hobbies);
console.log("-------------------");

hobbies.unshift("Sleeping","Bird Watching")
console.log("hobbies after unshift",hobbies); 

console.log("-----------------------------");

hobbies.shift()
console.log("hobbies after shift",hobbies);

console.log("---------------------------");
var isHobbiesArray=Array.isArray(hobbies)
console.log("is hobbies  array "+isHobbiesArray);


console.log("---------------------------");

var hasCooking=hobbies.includes("Cooking",3)
console.log("has cooking "+hasCooking);

console.log("---------------------------");

var indexSinging=hobbies.indexOf("Singing");
console.log("index of Singing "+indexSinging);

console.log("---------------------------");

var str=hobbies.join("---");
console.log("join method "+str);

console.log("---------------------------");

var brands=["signature","Bisleri","Kinshifer","kinley"]

brands.splice(1,1,"Ibbanni")


console.log("brands after splice "+brands);


 var movies=["Bangarada Manushya","Bhoo Kailas","Mother India","Balan","Indian"]
var sliceMovies=movies.slice(1,3)
console.log("After slice ",movies);
console.log("After slice ",sliceMovies);
console.log("---------------------------");

var newMovies=movies.slice();
newMovies.splice(1,0,"Lucifer")
console.log("New Array",newMovies);
console.log("old Array ",movies);
var a=new Array(movies)
console.log(a);

console.log("---------------------------");

console.log(movies.sort());
var num=[100,250,25,868,365]
console.log(num.sort((a,b)=>a-b));

console.log(num.reduce((x,y)=>x+y));


console.log("---------------------------");
 
