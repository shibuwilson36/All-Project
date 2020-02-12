var numbers = [100, 200, 300, 400]

var filterNumber = numbers.filter(function (val) {

    if (val > 200) {
        return true
    } else {
        return false
    }

})
console.log("after filter ", numbers);
console.log("after filter ", filterNumber);

var filNumber = numbers.filter(val => val > 200)
console.log("after filter ", filNumber);

console.log("---------------------------");
var mapNumbers = numbers.map(function (val, index) {
    val = val + 50;
    return val;
})
console.log("after map ",mapNumbers);
console.log("after map ",numbers);
console.log("---------------------------");

var mapNumbers = numbers.map(val=>val + 50)
console.log("after map ",mapNumbers);
