//Global this
console.log("this is wind object",this);

//arrow function
display=()=>{
    //this is parent context ie window object
    console.log("This is window object ", this);
    
}
function show() {
    //this is a window object as it is invoke by window object
    console.log("This is window object ", this);
    
}
display()
show()

console.log("----------------------------------");

const Person={
    firstName:"Katrina",
    lastName:"Kalf",
    color:"white",
    getFullName:function () {
        //this is a person object as it invoked by person
        //object reference
        console.log("This is parent object ",this);
        
    },
    getColor:function () {
        //this is a person object as it invoked by person
        //object reference
        console.log("This is parent object ",this);
        
    getData: () =>{
        //this is a parent context ie person object
        console.log("This is parent object ",this);
        
    }
    function showData() {
        //this is window object as it invoked
        //by window refernce
        console.log("this is window object",window);
        
    }
    getData()
    showData()
        
    }
}







function Employee(name, age) {
    this.ename = name;
    this.eage = age;
    this.walk = function () {
        //this equal to employe object
        console.log("thi i employe object", this);

        console.log("Walk function excicuted ");

    }
    this.getName = function () {
        //this is window object as it invoke by window object ref
        console.log("this is window object", this);
        getData = function () {
            //this is the parent context i.e employe object
            console.log("----------------------------------");

            console.log("this is window object", this);
        console.log("----------------------------------");



        }

        //arrow functions
        getData = () => {
            //this is the parent context i.e employe object
            console.log("this is window object", this);

        }
        console.log("----------------------------------");

        getData()
        console.log("----------------------------------");

        return this.ename

    }

}

const mark = new Employee("mark Zuckerberg", 33);

console.log("Name is", mark.ename);
console.log("age is", mark.eage);

mark.walk()
let name = mark.getName()
console.log("Name ", name);


console.log("----------------------------------");
