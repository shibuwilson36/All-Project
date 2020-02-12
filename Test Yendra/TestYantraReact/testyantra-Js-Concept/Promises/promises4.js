const myPromise1 = new Promise(function(resolve, reject) {
    setTimeout(() => {
        resolve("myPromise1 Executed")

    }, 1000);
})
const myPromise2 = new Promise(function(resolve, reject) {
    setTimeout(() => {
        resolve("myPromise2 Executed")

    }, 1000);
})
Promise.race([myPromise1, myPromise2])
    .then(function(response) {
        console.log("Response ", response);

    }).catch(function(error) {
        console.log("error ", error);

    })