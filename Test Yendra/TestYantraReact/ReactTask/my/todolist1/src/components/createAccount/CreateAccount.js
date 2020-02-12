import React, { Component } from 'react'
import Axios from 'axios'





export default class CreateAccount extends Component {

    state = {
        userName: "",
        userEmail: "",
        userMobile: "",
        userPassword: "",

    }
    handelChange = (event) => {
        const value = event.target.value
        this.setState({
            [event.target.name]: value
        })

    }
    saveData = (event)=>{
        event.preventDefault()
        console.log(this.state);
        const formData = this.state

        const url = "https://react-app-2a568.firebaseio.com/account.json"

        Axios.post(url,formData).then((response)=>{
            console.log('Success',response);

         
        
            if(response.status === 200){
                this.setState(
                    {
                        userName: "",
                        email:"",
                        mobile:"",
                        password:""
                        
                    }
                )
               
            }
        }).catch((err)=>{
            console.log("Error",err);
            
        })

    }


    render() {
        const unameStyle = {
            color: 'red',
            fontSize: '10px'
        }
        const box = {
            border: "1px  solid red"
        }
        return (
            <div>

                <div id="form-card" className=" ml-0 mr-0 pt-3 pb-5">
                    <form onSubmit={this.saveData} >
                        <div id="form" className="form-group col-md-4 offset-4 card card-body">
                            <h1>Create Account</h1>
                            <label >Name</label>
                            <input
                                style={this.state.showName ? box : null}
                                name="userName"
                                className="form-control" type="text"
                                value={this.state.userName}
                                id="" placeholder="enter name"
                                onChange={this.handelChange}
                            ></input>
                            {this.state.showName ? <p style={unameStyle}>invalid username</p> : null}
                            <label >Email</label>
                            <input
                                style={this.state.showEmail ? box : null}
                                name="userEmail"
                                className="form-control" type="text"
                                value={this.state.userEmail}
                                id="" placeholder="enter Email"
                                onChange={this.handelChange}
                            ></input>
                            {this.state.showEmail ? <p style={unameStyle}>invalid Email</p> : null}
                            <label >Mobile</label>
                            <input
                                style={this.state.showMobile ? box : null}
                                name="userMobile"
                                className="form-control" type="text"
                                value={this.state.userMobile}
                                id="" placeholder="enter Mobile"
                                onChange={this.handelChange}
                            ></input>
                            {this.state.showMobile ? <p style={unameStyle}>invalid Mobile</p> : null}
                            <label >Password</label>
                            <input
                                style={this.state.showPassword ? box : null}
                                name="userPassword"
                                className="form-control" type="text"
                                value={this.state.userPassword}
                                id="" placeholder="enter Password"
                                onChange={this.handelChange}
                            ></input>
                            {this.state.showPassword ? <p style={unameStyle}>invalid Password</p> : null}
                            <button className="btn btn-outline-info col-md-6 offset-3 mt-3" id="login" type="submit">Create Account</button>
                        </div>



                    </form>
                </div>
            </div>
        )
    }
}
