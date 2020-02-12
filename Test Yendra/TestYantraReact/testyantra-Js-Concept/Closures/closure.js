function outer(params) {
    
    let num=10;
    function inner() {
        
        console.log("Number ",num);
        num++;
    }
    return inner;
}
let innerFun=outer()
innerFun()
innerFun()
innerFun()
innerFun()

