const person = {
    name: "Prabhas",
    age: 40,
    color: "white"
}

//using templete literal (String interpolation)

console.log(
    `
    Name is ${person.name}
    Age is ${person.age}
    Color is ${person.color}
    Income is ${2500000000} `);

let str="Hello"

let str1=str.split("")
let str2;
for (let i = str1.length-1; i >=0 ; i--) {
    
    str2=str1[i];
    
}
console.log(str2);
