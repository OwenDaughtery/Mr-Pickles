import React, { Component } from 'react';

class CurrentPlayer extends Component {
    constructor(props) {
        super(props);
        this.state = {
            playerIndex: -1
        };
    }

    render() {
        return (
            (this.state.playerIndex !== -1) ? 
                <p className="text-info">
                    It's player {this.state.playerIndex}'s turn to roll the dice.
                </p>
                :
                <p>
                    
                </p>
        );
    }
}
export default CurrentPlayer;