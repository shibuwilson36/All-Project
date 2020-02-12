 function Employee(name, age) {
     this.ename = name;
     this.eage = age;
     this.walk = function() {
         console.log("Walk function excicuted ");

     }
     this.getName = function() {
         return this.ename

     }
 }

 const mark = Employee("mark Zuckerberg", 33);

 console.log("Name is", this.ename);
 console.log("age is", this.eage);

 this.walk()
 let name = this.getName()
 console.log("Name ", name);