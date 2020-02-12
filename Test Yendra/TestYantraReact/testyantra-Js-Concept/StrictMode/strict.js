// "use strict"
/* var name="shibu"
var name="nidhin"
console.log(name); */

const firstName="Bill"
const lastName="Gates"
console.log(firstName);
console.log(lastName);
/* function showData() {

    console.log("this is ",this);
    
    console.log("show data function");
    
} */
function display() {
    
    console.log("this is ",this);
    console.log("display function");
    
}
display()

function showData() { 
    //this is undefine in strict mode for function
    //which is called like a normal function 
    "use strict"
    console.log("this is ",this);
    this.data="hello"
    console.log("show data function");
    
}
// showData()
new showData()


