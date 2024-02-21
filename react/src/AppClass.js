import React from "react";

class AppClass extends React.Component{

    state = {
        count : 0,
    };

    add = () => {
        this.setState({count: this.state.count + 1});
        //this.state.count += 1;
        console.log('add');
    };

    minus = () => {
        //this.state.count -= 1;
        this.setState({count: this.state.count - 1});
        console.log('minus');
    };

    render(){
        return <div>
        <h1>The number is : {this.state.count}</h1>
        <button onClick={this.add}>Add</button>
        <button onClick={this.minus}>Minus</button>
        </div>
    }
}

export default AppClass;