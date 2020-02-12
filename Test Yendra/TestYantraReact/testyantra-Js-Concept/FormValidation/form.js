const loginButton=document.getElementById("login")
loginButton.addEventListener("click",function () {

    const userForm=document.forms['userForm']
    const userElement=userForm.uerName
    const passwordElement=userForm.password
    
    const userName=userElement.value
    const password=passwordElement.value

    console.log("User Name is ",userName);
    console.log("User password is ",password);

    if(userName.trim().length>5){
        console.log("user name valid");
        
    }else{

        console.log("user name is not valid");

    }
    if(password.trim().length>5){
        console.log("password is valid");
        
    }else{
        console.log("password is not valid");


    }

})