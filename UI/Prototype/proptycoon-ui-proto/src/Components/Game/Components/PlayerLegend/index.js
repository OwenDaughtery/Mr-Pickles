import React, { Component } from 'react';
import Token from '../Token';

class PlayerLegend extends Component {
    //Generate HTML spans representing players.
    //Returns array of React elements.
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

    get numberOfPlayers() {
        return this.props.numberOfPlayers;
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
                    this._generateLegendEntries(this.props.numberOfPlayers)
                }
            </div>
        );
    }
}

export default PlayerLegend;