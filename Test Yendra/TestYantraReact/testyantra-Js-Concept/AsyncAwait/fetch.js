async function getData(params) {

    //fetch is return promis
    //awit will stop the execution until the fetch function excution stop
    const response = await fetch('https://jsonplaceholder.typicode.com/todos')
    const data = await response.json()
    console.log("data ", data);

}
getData()