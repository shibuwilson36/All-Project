//spread operator with array
const numbers=[100,200,300]
console.log("numbers ",numbers);

const copyOfNumbers=[...numbers]
console.log("copyNumbers ",copyOfNumbers);

numbers.push(500)
console.log("after push numbers ",numbers);
console.log("after push copyNumbers ",copyOfNumbers);

//

const animals=["Lion","tiger","cow","dog"]
const moreAnimals=["Giraffe","Camel","pums","humans"]
const copyOfanimals=[...animals,...moreAnimals]

console.log("copyOfanimals ",copyOfanimals);

//Spread  perator with object

const person={
    name:"Sundara",
    age:23,
    height:5.7,
    weight:68
}
const copyOfPerson={...person}

copyOfPerson.name="Sundari"
console.log("person ",person);
console.log("copyOfPerson ",copyOfPerson);

const teacher={
    name:"Reena",
    age:30,
    color:"pink",
    subject:["Social","English"]
   
}
const address={
    city:"Bangaluru",
    pincod:560068,
    landmark:"BTM"
}

const teacherWithAddress={...teacher,...address}

console.log("teacherWithAddress ",teacherWithAddress);

const teacherWithPhone={
    ...teacherWithAddress,
    phone:987856535,
    married:false,
    getName:function () {
        return this.name
    }
}

console.log("Teacher with phone ",teacherWithPhone);
