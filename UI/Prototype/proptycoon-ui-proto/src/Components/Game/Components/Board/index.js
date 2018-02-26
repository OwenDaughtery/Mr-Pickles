import React, { Component } from 'react';
import Container from './Components/Container';
import Cell from './Components/Cell';
import Dice from './Components/Dice';
import TurnInfo from './Components/TurnInfo';

class Board extends Component {
    /**
     * Creates a react component instance (element).
     * Initialises state:
     *  - Container dimensions set to 0.
     *  - Portrait check is set to null.
     * Binds resize event to window listener.
     * @param {Array<*>} props - React properties passed to this element.
     */
    constructor(props) {
        super(props);
        //Initialise state.
        this.state = {
            containerWidth: 0,
            containerHeight: 0,
            portrait: null
        };
        //Create binding for onResize
        this._resizeBinding = () => { this._onResize() };
        //Bind onResize to window resize event.
        window.addEventListener("resize", this._resizeBinding);
    }

    /**
     * Portrait state boolean set to match viewport's orientation.
     * @private
     */
    _updateOrientation() {
        this.setState({
            portrait:  window.innerHeight > window.innerWidth
        });
    }

    /**
     * True if viewport orientation is portrait.
     * False if landscape.
     * @type Boolean
     * @property
     * @public
     */
    get portrait () { return this.state.portrait; }

    /**
     * Board element just mounted.
     * (Page has loaded.)
     * @public
     */
    componentDidMount() {
        this._updateOrientation();
    }

    /**
     * Fires when viewport is resized.
     * @private
     * @event
     */
    _onResize() {
        this._updateOrientation();
    }

    /**
     * Board element is about to unmount.
     * (Page is changing or being closed.)
     * @public
     */
    componentWillUnmount() {
        window.removeEventListener("resize", this._resizeBinding);
    }

    /**
     * Pass the current absolute width & height values of the board container, to the board.
     * @param {Object} dimensions - Contains width and height values in object format {width: ##, height: ##}.
     */
    set containerDimensions(dimensions) { 
        this.setState({
            containerWidth: dimensions.width,
            containerHeight: dimensions.height
        });
    }

    /**
     * Create board cells.
     * @private
     */
    _generateCells() {
        //Array to contain cell React elements.
        var cells = [];
        //Cycle through board's 40 cells.
        for (var i=0; i<40; i++) {
            cells.push(
                <Cell position={i} cellSize={this.props.cellSize} />
            );
        }
        return cells;
    }

    /**
     * Render board.
     */
    render() {
        var portrait = this.state.portrait;
        var style = {
            width: portrait ? this.props.percentSize + "vw" : this.props.percentSize + "vh",
            height: portrait ? this.props.percentSize + "vw" : this.props.percentSize + "vh",
            display: "inline-block",
            position: "relative",
            backgroundColor: "white",
        };
        return (
            <Container parent={this}>
                <div id="propertyTycoonBoard" style={style}>
                    { this._generateCells() }
                    <TurnInfo board={this}/>
                    <Dice />
                </div>
            </Container>
        );
    }
}

/**
 * @type Object
 */
Board.defaultProps = {
    percentSize: 90,
    cellSize: "12%"
};

export default Board;