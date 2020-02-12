/* const item = React.createElement('ul', { id: "hot drinks" },
    React.createElement("li", { id: 'coffee' }, "Coffee"),
    React.createElement("li", { id: "tea" }, "Tea")
)
const table = React.createElement("table", null,
    React.createElement("tr", null,
        React.createElement("th", null, "name"),
        React.createElement("th", null, "Phone")),
    React.createElement("tr", null,
        React.createElement("th", null, "Shibu"),
        React.createElement("th", null, "9562645910")))

const div = React.createElement("div", null, item, table)
ReactDOM.render(div, document.getElementById("react-container")) */
/* 
let list = ["Coffee", "Tea"]
const item = React.createElement('ul', { id: "hot drinks" },
    list.map((list, index) => {
        return React.createElement("li", {
            key: `list${index}`
        }, list)
    })
)

let person = [{
        name: "shibu",
        phone: "9562645910"
    },
    {
        name: "Nidhin",
        phone: "953927910"
    }
]

const table = React.createElement("table", null,
    React.createElement("thead", { key: "head" },
        React.createElement("th", null, "name"),
        React.createElement("th", null, "Phone")),
    person.map((person, index) => {
        return React.createElement("tbody", { key: `person${index}` },
            React.createElement("td", { key: `${person.name}` }, person.name),
            React.createElement("td", { key: `${person.phone}` }, person.phone))
    }))

const div = React.createElement("div", null, item, table)
ReactDOM.render(div, document.getElementById("react-container")) */


let list = ["Coffee", "Tea"]
const item = React.createElement('ul', { id: "hot drinks" },
    list.map((list, index) => {
        return React.createElement("li", {
            key: `list${index}`
        }, list)
    })
)

let person = [{
        name: "shibu",
        phone: "9562645910"
    },
    {
        name: "Nidhin",
        phone: "953927910"
    }
]

const table = React.createElement("table", {
        className: 'tableBorder'
    },
    React.createElement("thead", {
            key: "head",
            className: 'header'
        },
        React.createElement("tr", null,
            React.createElement("th", null, "name"),
            React.createElement("th", null, "Phone"))),
    person.map((person, index) => {
        return React.createElement("tbody", {
                key: `person${index}`,
                className: 'body'
            },
            React.createElement("td", { key: `${person.name}` }, person.name),
            React.createElement("td", { key: `${person.phone}` }, person.phone))
    }))

const div = React.createElement("div", null, item, table)
ReactDOM.render(div, document.getElementById("react-container"))