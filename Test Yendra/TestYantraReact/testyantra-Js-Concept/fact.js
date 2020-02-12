function fact(x) {
    if (x === 0) {
        return 1;
    }
    return x * fact(x - 1);

}
console.log(fact(3));


// let s=(function (x) {
//     if (x == 0) {
//         return 1;
//     }
//     return x * fact(x - 1);

// })(5)
// console.log(s);