localStorage.setItem("role","admin")
localStorage.setItem("email","abc@gmail.com")

const email=localStorage.getItem("email")
console.log("Email id :",email);

localStorage.removeItem("role")

const role=localStorage.getItem("role")
console.log("role  :",role);
localStorage.clear()