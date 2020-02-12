class Header extends React.Component {

    
    render() {
        return <h1>This is Header</h1>

    }
}

class Content extends React.Component {

   
    render() {
    return <h1>Welcom {}</h1>
       

    }
}
class Footer extends React.Component {

   
    render() {
        return <h1>This is Footer</h1>
        

    }
}


ReactDOM.render(<div><Header/><Content name="Shibu" /><Footer/></div>,document.getElementById("react-container"))
