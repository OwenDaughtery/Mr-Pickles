import React, { Component } from 'react';
import Die from './Components/Die';
import Roll from './Components/Roll';

class Dice extends Component {
    render() {
        var style = {
            position: "absolute",
            left: "50%",
            top: "50%",
            maxWidth: "50%",
            transform: "translate(-50%, -50%)",
            textAlign: "center"
        };
        var leftDieStyle = {
            textAlign: "right"
        };
        var rightDieStyle = {
            textAlign: "left"
        };
        var rollRowStyle = {
            marginTop: "8pt"
        };
        return (
            //Uses Bootstrap 4
            <div className="container" style={style}>
                <div className="row">
                    <div className="col" style={leftDieStyle}>
                        <Die/>
                    </div>
                    <div className="col" style={rightDieStyle}>
                        <Die/>
                    </div>
                </div>
                <div>
                    <div className="col" style={rollRowStyle}>
                        <Roll/>
                    </div>
                </div>
            </div>
        );
    }
}

export default Dice;