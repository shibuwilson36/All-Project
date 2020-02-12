class Parent extends React.Component {

    constructor(props) {
        super(props)
        console.log("Parent Construtor");

        this.state = {
            name: "LifeCycle",
            show: true
        }

    }
    changeName = () => {
        this.setState({
            name: "upadte"
        })
    }
    removeChild = () => {
        this.setState({
            show: false
        })
    }
    static getDerivedStateFromProps(props, state) {
        console.log("Parent getDerviedStateFromProps");
        return null
    }
    render() {
        console.log("Parent component");

        return (
            <div>
                <h1> Parent component</h1>
                {this.state.show?<Child/>:<h1>Child Remove</h1>}
                <button onClick={this.changeName}>Click</button>
                <button onClick={this.removeChild}>remove Child</button>
            </div>
        )


    }
    componentDidMount() {
        console.log("Parent componentDidMount ");

    }
    shouldComponentUpdate() {
        console.log("Parent shouldComponentUpdate");
        return true

    }
    getSnapshotBeforeUpdate(prevState, prevProps) {

        console.log("Parent getSnapshotBeforeUpdate");
        console.log("prvs", prevState.name);
        console.log("current", this.state.name);

        return "Scorling position"
    }
    componentDidUpdate(prevState, prevProps, snapShot) {
        console.log("-----Parent componentDidUpdate-----");
        console.log("Parent state", prevState);
        console.log("Parent snapShot", snapShot);


    }
    componentWillUnmount () {
        console.log("Parent componentWillUnMount");

    }

}
class Child extends React.Component {
    constructor(props) {
        super(props)
        console.log("Child constructor");
        this.state = {
            name: "LifeCycle"
        }

    }
    static getDerivedStateFromProps(props, state) {
        console.log("Child getDerviedStateFromProps");
        return null
    }
    render() {
        return (
            <div>
                <h1>Child Component</h1>
            </div>
        )

    }
    componentDidMount() {
        console.log("Child componentDidMount ");

    }
    shouldComponentUpdate() {
        console.log("Child shouldComponentUpdate");
        return true

    }
    getSnapshotBeforeUpdate(prevState, prevProps) {

        console.log("Child getSnapshotBeforeUpdate");
        

        return "Scorling position"
    }
    componentDidUpdate(prevState, prevProps, snapShot) {
        console.log("-----Child componentDidUpdate-----");
       


    }
    componentWillUnmount() {
        console.log("Child componentWillUnMount");

    }


}
ReactDOM.render(<div>
    <Parent />
</div>, document.getElementById("react-container"))
