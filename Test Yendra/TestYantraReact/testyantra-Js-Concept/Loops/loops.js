var fruits = ["Apple", "Orange", "Grapes", "Mango", "kiwi"]
//for loop
for (let i = 0; i < fruits.length; i++) {

    console.log("fruits " + fruits[i]);

}
//for of loop
console.log("-------for of-------");
for (var fruit of fruits) {
    console.log("Using for of : " + fruit);

}
//for in loop
console.log("-------for in-------");

for (const index in fruits) {
    console.log("index is " + index);
    console.log("fruit is " + fruits[index]);


}
var person = {
    name: 'priyanka',
    college: "APS",
    hasBf: false
}
console.log("-------for in -------");
for (var key in person) {
    console.log("key is " + key);
    console.log("value is ", person[key]);
}
var fruits = ["Apple", "Orange", "Mango"]

console.log("-------for each -------");

fruits.forEach(function (value, index) {

    console.log("index is ", index);
    console.log("value is " + value);


}) 