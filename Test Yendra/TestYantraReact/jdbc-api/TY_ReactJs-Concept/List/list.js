const item = React.createElement('ul', { id: "hot drinks" },
    React.createElement("li", { id: 'coffee' }, "Coffee"),
    React.createElement("li", { id: "tea" }, "Tea")
)

const mobiles = ["Honor", "oppo", "Samsung", "Nokia", "Redmi", "Lenovo", "OppoS"]

const mobileList = React.createElement("ul", null,
    mobiles.map((mobile, index) => {
        return React.createElement("li", {
            key: `${mobile}${index}`
        }, mobile)
    }))
const allItem = React.createElement("div", null, item, mobileList)
console.log("item", mobileList);

ReactDOM.render(allItem, document.getElementById("react-container"))
    // ReactDOM.render(item, document.getElementById("react-container"))
    // ReactDOM.render(mobileList, document.getElementById("react-container"))