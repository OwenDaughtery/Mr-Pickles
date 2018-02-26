import React, { Component } from 'react';
import Board from './Components/Board';
import PlayerLegend from './Components/PlayerLegend';

class Game extends Component {
    render() {
        return (
            <div>
                <PlayerLegend />
                <Board />
            </div>
        );
    }
}

export default Game;