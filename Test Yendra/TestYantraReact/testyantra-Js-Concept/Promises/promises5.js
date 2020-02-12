const myPromise1 = new Promise(function(resolve, reject) {
    resolve([10, 20, 30]);

})
const myPromise2 = new Promise(function(resolve, reject) {
    resolve([10, 20, 40]);

})
Promise.race([myPromise1, myPromise2])
    .then(function(response) {
        console.log("Response ", response);

    }).catch(function(error) {
        console.log("error ", error);

    })