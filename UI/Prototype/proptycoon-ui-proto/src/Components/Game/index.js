import React, { Component } from 'react';
import Board from './Components/Board';
import PlayerLegend from './Components/PlayerLegend';
import api from '../../API';

class Game extends Component {
    componentDidMount() {
        api.startGame(4, {primary: 0, secondary: 0});
    }

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