import React, { Component } from 'react';

class Container extends Component {
    constructor(props) {
        super(props);
        //Get parent board.
        this._board = this.props.parent;
        //Function for getting DOM node of this component.
        this._domBinding = (node) => { this._domNode = node };
        //Create binding for onResize
        this._resizeBinding = () => { this._onResize() };
        //Bind onResize to window resize event.
        window.addEventListener("resize", this._resizeBinding);
    }
    
    _sendDimensions() {
        this._board.containerDimensions = {width: this._domNode.clientWidth, height: this._domNode.clientHeight};
    }

    componentDidMount() {
        this._sendDimensions();
    }

    _onResize() {
        this._sendDimensions();
    }

    componentWillUnmount() {
        //Remove window resize event listener.
        window.removeEventListener("resize", this._resizeBinding);
    }

    render() {
        var style = {
            width: "100%",
            height: "100%",
            backgroundColor: "navy"
        };
        return (
            <div id="propertyTycoonContainer" style={style} ref={this._domBinding}>
                {this.props.children}
            </div>
        );
    }
}

export default Container;