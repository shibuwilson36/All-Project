/* const john = {
    name: 'john',
    age: 23,
    presentation: function(...arr) {
        if (arr[0] === "formal")
            console.log(`Good ${arr[1]}, this is ${this.name}`);
        else
            console.log(`hey ${arr[1]}, this is  ${this.name}`);



    }
} */



const john = {
    name: 'john',
    age: 23,
    presentation: function(style, timeOfDay) {
        if (style === "formal")
            console.log(`Good ${timeOfDay}, this is ${this.name}`);
        else
            console.log(`hey , this is  ${this.name}`);



    }
}
john.presentation('formal', 'Morning')

console.log("-------------------");


const babitha = {
    name: 'babitha',
    age: 23

}


john.presentation.call(babitha, 'frindly', "evening")

const emily = {
    name: 'emily',
    age: 22

}
console.log("-------------------");

john.presentation.apply(emily, ['formal', "night"])


const vijay = {
    name: 'vijay',
    age: 50

}
console.log("-------------------");
//bind does not excutes the function instead
//It will createb the copy of the function and it will return
//we can  reuse the function whenever required with diff parameters


const bindFunction = john.presentation.bind(vijay, 'frindly')
bindFunction("Morning")
bindFunction("Evening")
bindFunction("Night")
console.log("-------------------");