import React, { Component } from 'react';

class Die extends Component {
    constructor(props) {
        super(props);
        this.state = {
            value: "##"
        };
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