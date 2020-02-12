class Header extends React.Component {

    constructor(props) {
        super(props)
        console.log("props", props);

    }
    render() {
        return React.createElement("h1", null, this.props.headerValue)

    }
}

class Content extends React.Component {

    constructor(props) {
        super(props)
        console.log("props", props);

    }
    render() {
        return React.createElement("h1", null, "this is Content")

    }
}
class Footer extends React.Component {

    constructor(props) {
        super(props)
        console.log("props", props);

    }
    render() {
        return React.createElement("h1", null, "this is Footer")

    }
}

const header = React.createElement(Header, {
    headerValue: "This is Header ",

})
const content = React.createElement(Content)
const footer = React.createElement(Footer)
const homePage = React.createElement("div", null, header, content, footer)

ReactDOM.render(homePage, document.getElementById("react-container"))