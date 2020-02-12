const person = {
    name: "Yash",
    age: 30,
    color: "pink",
    hobbies: ["Singing", "Acting", "Cricket"],
    address: {
        city: "Bangalor",
        pin: 56008
    },
   c:undefined,
   add:function () {
       console.log("hai");
       return 20
   },
   c:Math.floor(2.56)
}

console.log("Js person object ",person);

const jsonPerson= JSON.stringify(person)
console.log("Json person object ",jsonPerson);

const jsPerson=JSON.parse(jsonPerson)
console.log("js person ",jsPerson);
