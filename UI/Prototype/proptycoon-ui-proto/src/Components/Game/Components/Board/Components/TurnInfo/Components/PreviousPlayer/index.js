import React, { Component } from 'react';

class PreviousPlayer extends Component {
    constructor (props) {
        super(props);
        this.state = {
            playerIndex: -1
        };
    }

    render() {
        return (
            (this.state.playerIndex !== -1) ? 
                <p className="text-success">
                    Player {this.state.playerIndex} just moved.
                </p> 
                : 
                <p>

                </p>
        );
    }
}

export default PreviousPlayer;