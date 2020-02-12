async function getData(params) {

    console.log("getData() function started");

    try {
        const response = await fetch('https://jsonplaceholder.typicode.com/todos')
        const data = await response.json()
        console.log("data ", data);
    } catch (error) {

        console.log("error", error);
    } finally {
        console.log("finally executed");

    }
    console.log("getData() function ended");


}
getData()