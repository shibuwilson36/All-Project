function sum(...nums) {

    let sum=0;
    for (const num of nums) {
        sum+=num
    }
    return sum;
}
const value=sum(10,20)
console.log("value is ",value);
const value1=sum(10,20,40)
console.log("value is ",value1);

function printAnimals(animal1,animal2,...animals) {
    
    console.log(animal1);
    console.log(animal2);

    // for(let i=0;i<animals.length;i++){
    //     console.log(animals[i]);
        
    // }
    for (const animal of animals) {
        console.log(animal);
    }
    
}
printAnimals("Lion","Tiger","cow","dog")

