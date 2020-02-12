function first(callback) {
    setTimeout(() => {
        console.log("First func");
        callback()
    },0 );

}
function second() {
    console.log("second func");
}
first(second);

function myFirst() {
    var i=0;
    var id=setInterval(() => {
        console.log(i++);

        if(i===5){
            clearInterval(id);
        }
    }, 1000);

    
}
myFirst();