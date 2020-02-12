const myPromise1 = new Promise(function(resolve, reject) {
    setTimeout(() => {
        resolve("myPromise1 Executed")

    }, 4000);
})
const myPromise2 = new Promise(function(resolve, reject) {
    setTimeout(() => {
        resolve("myPromise2 Executed")

    }, 1000);
})

const myPromise3 = new Promise(function(resolve, reject) {
    setTimeout(() => {
        reject("myPromise3 reject")

    }, 1000);
})
Promise.all([myPromise1, myPromise2, myPromise3])
    .then(response => {
        console.log("Response ", response);

    }).catch(function(error) {
        console.log("error ", error);

    })