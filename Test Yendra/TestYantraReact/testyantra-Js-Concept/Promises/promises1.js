console.log("Js Started.......");


const myPromise = new Promise(function(resolve, reject) {

    if (20 > 10) {
        const data = [100, 200, 300, 400]
        resolve(data)
    } else {
        reject("faided to fetch the data")

    }

})

myPromise.then(function(data) {

    console.log("data is :", data);

    const filterData = data.filter(val => val > 200)

    return filterData


}).then(function(filterData) {

    console.log("filter Data is :", filterData);


}).catch(function(error) {

    console.log("error is", error);

})

console.log("Js end.......");