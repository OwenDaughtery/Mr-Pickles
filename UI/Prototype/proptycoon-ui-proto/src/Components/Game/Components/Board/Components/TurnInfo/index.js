import React, { Component } from 'react';
import PreviousPlayer from './Components/PreviousPlayer';
import CurrentPlayer from './Components/CurrentPlayer';

class TurnInfo extends Component {
    constructor(props) {
        super(props);
        this._cellSize = this.props.board.props.cellSize;
    }
    render() {
        var style = {
            position: "absolute",
            left: "50%",
            top: this._cellSize,
            width: "50%",
            height: "auto",
            transform: "translate(-50%, 0)",
            marginTop: "24pt"
        }
        return (
            <div className="container" style={style}>
                <PreviousPlayer />
                <CurrentPlayer />
            </div>
        );
    }
}

export default TurnInfo;