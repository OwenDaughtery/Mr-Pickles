import React, { Component } from 'react';
import Token from '../Token';

class PlayerLegend extends Component {
    constructor(props) {
        super(props);
        this.state = {
            numberOfPlayers: 5
        };
    }

    _generateLegendEntries() {
        var legendEntries = [];
        for (var i = 0; i < this.state.numberOfPlayers; i++) {
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
                    this._generateLegendEntries()
                }
            </div>
        );
    }

    
}

export default PlayerLegend;