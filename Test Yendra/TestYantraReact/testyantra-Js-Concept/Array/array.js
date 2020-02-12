var fruits=["Apple","Mango","Orange","Butterfruit"];

console.log(fruits);
console.log(fruits[0]);
console.log(fruits[1]);
console.log(fruits[2]);
console.log(fruits[3]);
console.log("-------------------------------");


for(var i=0;i<fruits.length;i++){
    console.log(fruits[i]);
    
}


console.log("-------------------------------");

var person=["Anu",40,true,null,undefined];

for(var i=0;i<person.length;i++){
    console.log("Person Data "+person[i]);
    
}

console.log("-------------------------------");
var num=10;
var str="10";
if(num===str){
    console.log("Equals");
    
}else{
    console.log("not Equals ");
    
}