class Welcome extends React.Component{
    state ={
        name:"Nidhin",
        show:false
        
    }
    constructor(props){
        super(props)
        console.log("inside constructor",this);
        
        
    }
   
    //Best way of writing the function
    handlClick=()=>{
        console.log("inside handlClick",this);
        
        console.log("Inside arrow function",this.state.name);
        //Never ever mutate stae dirctly
        //this.state.name="shibu"
        this.setState({
            name:"Shibu"
        })
        
    }
    render(){
        console.log("inside render",this);

        return(<div>
            <h1>Hello ,{this.state.name+" "+this.state.show}</h1>
            
            <button onClick={this.handlClick}> Click here to change the name</button>

        </div>
        )
    }
}

ReactDOM.render(<Welcome/>,document.getElementById("react-container"))