import React, {Component} from 'react';

class ResultComponent extends Component {


    render() {
        let {result} = this.props;
        return (
            <div className=" col-md-11 ml-3 result">
                <p>{result}</p>
            </div>
    )
        ;
    }
}


export default ResultComponent;

