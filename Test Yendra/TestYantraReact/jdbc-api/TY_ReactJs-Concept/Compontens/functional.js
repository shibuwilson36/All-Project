/* function Header({ headerName }) {

    return React.createElement("h1", null, headerName)

}

const header = React.createElement(Header, {
    headerName: "This is header",
    id: "header",
    show: true
}, "Header components")
console.log(header);

ReactDOM.render(header, document.getElementById("react-container")) */








function Header(props) {

    props.headerName = "hello world "
    console.log(props.headerName);

    console.log(props);

    return React.createElement("h1", null, props.headerName)

}

const header = React.createElement(Header, {
    headerName: "This is header",
    id: "header",
    show: true
}, "Header components")


function Footer(props) {
    return React.createElement("h1", null, "This is footer")
}
const footer = React.createElement(Footer, null)


function Content(props) {
    return React.createElement("h1", null, "This is Content")
}

const content = React.createElement(Content, null)

const homePage = React.createElement("div", null, header, content, content, footer)
ReactDOM.render(homePage, document.getElementById("react-container"))