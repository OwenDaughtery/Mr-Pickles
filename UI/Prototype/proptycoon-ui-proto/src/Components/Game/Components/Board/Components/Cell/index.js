import React, { Component } from 'react';
import Token from '../../../Token';

class Cell extends Component {
    constructor(props) {
        super(props);
        this.state = {
            players: [
                {index: 1}
            ]
        };
        this._generateStyle();
        this._generateTokens();
    }

    _generateStyle() {
        //Positions:
        // Bottom: 0->9
        // Left: 10->19
        // Top: 20->29
        // Right: 30->39
        this._position = this.props.position;
        //Where the cell is located on it's row. (0->9)
        var rowPosition = this._position % 10;
        //Whether cell is located at corner of board.
        var cornerCell = rowPosition === 0;
        //Height of cell in CSS size units.
        var cellHeight = this.props.cellSize;
        //Width of corner cell.
        var cornerCellWidth = cellHeight;
        //Width of cell in CSS size units.
        var cellWidth = cornerCell ? cornerCellWidth : "((100% - " + cornerCellWidth + " * 2) / 9)";
        //CSS positioning values of cell.
        var left, top;
        //Width & height of cell in CSS size units.
        var width, height;
        //Bottom row.
        if (this._position < 10) {
            left = "100% - " + cornerCellWidth + " - " + cellWidth + " * " + rowPosition;
            top = "100% - " + cellHeight;
            width = cellWidth;
            height = cellHeight;
        }
        else if (this._position < 20) {
            left = "0%";
            top = "100% - " + cornerCellWidth + " - " + cellWidth + " * " + rowPosition;
            width = cellHeight;
            height = cellWidth;
        }
        else if (this._position < 30) {
            left = cornerCell ? "0%" : (cornerCellWidth + " + " + cellWidth + " * " + (rowPosition - 1));
            top = "0%";
            width = cellWidth;
            height = cellHeight;
        }
        else if (this._position < 40) {
            left = "100% - " + cellHeight;
            top = cornerCell ? "0%" : (cornerCellWidth + " + " + cellWidth + " * " + (rowPosition - 1));
            width = cellHeight;
            height = cellWidth;
        }
        //Generate this cell's style.
        this._style = {
            border: "1pt solid black",
            position: "absolute",
            display: "inline-block",
            left: "calc(" + left + ")",
            top: "calc(" + top + ")",
            width: "calc(" + width + ")",
            height: "calc(" + height + ")",
            padding: "4pt"
        };
    }

    _generateTokens() {
        var tokens = [];
        for(var player of this.state.players) {
            tokens.push(
                <Token playerIndex={player.index}/>
            );
        }
        return tokens;
    }

    render() {
        return (
            <div className="container" style={this._style}>
                {this._generateTokens()}
            </div>
        );
    }
}

Cell.defaultProps = {
    position: 0,
    cellSize: "20pt"
};

export default Cell;