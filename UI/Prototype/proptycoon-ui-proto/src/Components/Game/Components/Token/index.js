import React, { Component } from 'react';

class Token extends Component {
    get colour () {
        switch (this.props.playerIndex) {
            case 0:
                return "red";
            case 1:
                return "green";
            case 2:
                return "blue";
            case 3:
                return "yellow";
            case 4: 
                return "purple";
            case 5:
                return "orange";
            default:
                return "white";
        }
    }

    render() {
        var style = {
            display: "inline-block",
            width: "2vh",
            height: "2vh",
            border: "2pt solid darkgray",
            marginLeft: "2pt",
            marginRight: "2pt",
            backgroundColor: this.colour
        };
        return (
            <div style={style}>
                
            </div>
        );
    }
}

Token.defaultProps = {
    playerIndex: -1
};

export default Token;