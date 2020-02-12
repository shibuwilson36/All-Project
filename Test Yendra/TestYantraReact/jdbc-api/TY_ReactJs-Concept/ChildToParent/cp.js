class Parent extends React.Component {

    state={
        message:"Parent Data"
    }
    
    render() {
        return (
            <div>
                <h1>{this.state.message}</h1>
                <Child action={this.getDataFromChild}/>
            </div>
        )

    }
    getDataFromChild=(childData)=>{
        console.log("Child data =",childData);
        this.setState({
            message:childData
        })
        
    }
}

function Child(props)  {

    return (
    <div>
        <button onClick={()=>{
            props.action("This is Child Data ")
        }}> pass Data to Parent</button>
    </div>
    )

}
ReactDOM.render(<Parent/>,document.getElementById("react-container"))
