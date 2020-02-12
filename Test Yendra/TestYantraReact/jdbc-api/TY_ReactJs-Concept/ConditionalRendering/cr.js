class ConditionalRendering extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            adminName: "Chandru",
            userName: "Giri",
            isAdmin: false,
            adminId: 100,
            userId: 200
        }
    }

    changeUserAdmin = () => {
        this.setState({
            isAdmin:!this.state.isAdmin
        })
    }
    navigateToGoogle=(event)=>{
        console.log(event);
        
        event.preventDefault();
    }
    render() {
        // {
        //     if(this.state.isAdmin){
        //        return  <h1>{this.state.adminName}</h1>
        //     }else{
        //        return <h1>{this.state.userName}</h1>

        //     }
        // }


        // return this.state.isAdmin ? <h1>{this.state.adminName}</h1>:<h1>{this.state.userName}</h1>

        const admin = <div>
            <h1>
                {this.state.adminName}
            </h1>
            <h1>
                {this.state.adminId}
            </h1>

        </div>
        const user = <div>
            <h1>
              Name=  {this.state.userName}
            </h1>
            <h1>
               Id = {this.state.userId}
            </h1>

        </div>

        return (
            <div>
                {/* {this.state.isAdmin ? <h1>{this.state.adminName}</h1> : <h1>{this.state.userName}</h1>}
                {this.state.isAdmin ? <h1>{this.state.adminId}</h1> : <h1>{this.state.userId}</h1>} */}
                {this.state.isAdmin ? admin : user}
                <p>Home</p>
                <p>Login</p>
                <button onClick={this.changeUserAdmin}>Click</button>
                <a href="http://www.google.com" onClick={this.navigateToGoogle}>Navigate to Google</a>
            </div>
        )


    }

}
ReactDOM.render(<ConditionalRendering />, document.getElementById("react-container"))
