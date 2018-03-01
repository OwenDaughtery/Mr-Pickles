import React, { Component } from 'react';
import { primaryDieModel, secondaryDieModel } from './model.js';
import api from '../../../../../../../../API';

//Prop #1 - Die index (0 or 1).
class Die extends Component {
    constructor(props) {
        super(props);
        this.state = {
            value: "##"
        };
        if (this.props.index === 0) 
            primaryDieModel.parentComponent = this;
        else if (this.props.index === 1)
            secondaryDieModel.parentComponent = this;
        else
            api.error("Die index out of range.");
            ;
    }

    set value(val) {
        this.setState({
            value: val
        });
    }

    render() {
        var style = {
            width: "24vw",
            height: "20vh",
            maxWidth: "60pt",
            maxHeight: "40pt",
            textAlign: "center",
            fontSize: "3vh"
        };
        return (
            <input type="text" style={style} value={this.state.value} readonly></input>
        );
    }
}

export default Die;