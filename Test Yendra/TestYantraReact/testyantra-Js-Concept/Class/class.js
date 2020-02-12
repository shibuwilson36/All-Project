class Person {
    constructor(fname, lname, age) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }
    getFullName() {
        return this.fname + " " + this.lname
    }

}
const person = new Person("Nazriya", "Fahadh", 26);

console.log("First name ", person.fname);
console.log("last name ", person.lname);
console.log("age ", person.age);
const fullName = person.getFullName();
console.log("Full name ", fullName);

class Teacher extends Person {
    constructor(fname, lname, age, subject) {
        super(fname, lname, age)
        this.subject = subject;
        
    }
    getSubject(){
         return this.subject   
    }
    static teachStyle(){
        return "Boring Teaching"
    }
}

const teacher = new Teacher("Rajeshwari", "Fahadh", 26, ["English", "Science"])

const teacherFullName = teacher.getFullName()
console.log("Full Name", fullName);

const subject = teacher.subject
console.log("Subject", subject);
const style=Teacher.teachStyle()
console.log("Teaching style ",style);

console.log("First Name", teacher.fname);
console.log("last Name", teacher.lname);
console.log("Age", teacher.age);