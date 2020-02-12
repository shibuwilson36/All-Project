function App(props) {

    return (
        <div>
            <Home homeName='Oila' />
            <List list={['Bag','Book','Pen']} />

        </div>
    )

}
function List(props) {

    return (
        <ul>
            {props.list.map((val,index)=>{
           
           return <li key={val+index}> {val}</li>
            })}
        </ul>
    )

}
function Home(props) {

    return (
        <div>
           <h1> {props.homeName}</h1>
        </div>
    )

}

ReactDOM.render(<App />, document.getElementById("react-container"))
