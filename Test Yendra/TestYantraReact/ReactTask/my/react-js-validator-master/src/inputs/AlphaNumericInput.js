import {
    Valid,
    Letter,
    AlphaNumeric,
    Email,
    CustomRx, Numeric,
    Required, Dummy
} from '../Function'

import React, { Component } from 'react';
export class AlphaNumericInput extends Component {
    constructor(props) {
        super(props)
        this.state = {
            input: '',
            errorStatus: '',
            errorMsg: true
        }
    }
    Valid(data) {
        let result = AlphaNumeric(data, this.props.min ?this.props.min:null, this.props.max ?this.props.max:null);
        console.warn("result", result)
        if (result.status) {
            this.setState({ errorStatus: false, errorMsg: '' })
        }
        else {
            this.setState({ errorStatus: true, errorMsg: result.msg })

        }
        if (this.props.onChange) {
            this.props.onChange()
        }
    }
    // onChange: (e) => this.Valid(e.target.value, this.props.min ? this.props.min : null, this.props.max ? this.props.max : null),
    
    render() {
        
        let data = this.props
        let collection = React.createElement("div", {},
            React.createElement("span", { className: this.props.class ? this.props.class : 'error-span' }, this.state.errorMsg),
            React.createElement("input", {
                type: "text",
                onChange: (e) => this.Valid(e.target.value),
                onBlur: (e) => this.props.return(this.state.errorStatus)
            }
            )
        )
        return (collection)
    }
}

