import React, { Component } from 'react';

class Roll extends Component {
    constructor(props) {
        super(props);
        this.state = {
            canRoll: true
        };
    }

    render() {
        return (
            <button type="button" class="btn btn-primary" disabled={!this.state.canRoll}>
                Roll
            </button>
        );
    }
}

export default Roll;