import React, { Component } from 'react';
import Token from '../Token';
import { game } from '../../../../Models/Game';

class PlayerLegend extends Component {
    constructor(props) {
        super(props);
        //Initialise state.
        this.state = {
            numberOfPlayers: 0
        };
    }

    _generateLegendEntries(numberOfPlayers) {
        var legendEntries = [];
        for (var i = 0; i < numberOfPlayers; i++) {
            var spanStyle = {
                marginRight: "18pt"
            };
            legendEntries.push(
                <span className="text-info" style={spanStyle}>
                    Player #{i} -
                    <Token playerIndex={i} />
                </span>
            );
        }
        return legendEntries;
    }

    set numberOfPlayers(playerCount) {
        this.setState({
            numberOfPlayers: playerCount
        });
    }

    get numberOfPlayers() {
        return this.state.numberOfPlayers;
    }

    render() {
        var style = {
            marginBottom: "12pt"
        };
        return (
            <div style={style}>
                <p className="font-weight-bold">
                    Player Legend:
                </p>
                {
                    this._generateLegendEntries(this.numberOfPlayers)
                }
            </div>
        );
    }

    
}

export default PlayerLegend;