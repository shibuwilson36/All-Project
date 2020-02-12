const person={
    name:"Raj",
    age:80,
    weight:60,
    hobbies:["Acting","singing"]
}

const {hobbies}=person
console.log("hobbies ",hobbies);

function displayHobbies({hobbies}){

    for (const hobbie  of hobbies) {
        console.log(hobbie.toUpperCase());  
    }
    
}
displayHobbies(person)

//Array 