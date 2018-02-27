import React, { Component } from 'react';
import Board from './Components/Board';
import PlayerLegend from './Components/PlayerLegend';
import GameModel from '../../Models/Game';

class Game extends Component {
    constructor(props) {
        super(props);
        this.state = {
            model: new GameModel()
        }
    }

    render() {
        return (
            <div>
                <PlayerLegend gameModel={this.state.model} />
                <Board gameModel={this.state.model} />
            </div>
        );
    }
}

export default Game;