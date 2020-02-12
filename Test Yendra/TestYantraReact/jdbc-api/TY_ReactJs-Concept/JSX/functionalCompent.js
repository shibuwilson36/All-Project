function Header(props) {
    return <h1>This is Header</h1>
}
function Content(props) {
return <p>Welcome {props.name}</p>
}
function Footer(props) {
    return <h1>This is Footer {props.name}</h1>
    }


ReactDOM.render(<div><Header/><Content name="Shibu" /><Footer/></div>,document.getElementById("react-container"))