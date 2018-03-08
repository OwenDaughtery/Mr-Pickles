import React, { Component } from 'react';
import Board from './Components/Board';
import PlayerLegend from './Components/PlayerLegend';
import Controller from './controller.js';

class Game extends Component {
    constructor(props) {
        super(props);
        //Instantialise game controller.
        this._controller = new Controller(this);
        //Intialise state.
        this.state = {
            //Player count to pass to legend.
            numberOfPlayers: 0
        };
    }

    componentDidMount() {
        //Tell game controller to start a game.
        this._controller.start();
    }

    set numberOfPlayers(playerCount) {
        //Update state.
        this.setState({
            //Update value of player count to pass to legend.
            numberOfPlayers: playerCount
        });
    }

    render() {
        return (
            <div>
                <PlayerLegend numberOfPlayers={this.state.numberOfPlayers} />
                <Board />
            </div>
        );
    }
}

export default Game;