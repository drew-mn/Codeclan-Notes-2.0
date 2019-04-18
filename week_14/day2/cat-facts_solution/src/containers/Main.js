import React, { Component } from 'react';
import FactBox from '../components/FactBox';
import './Main.css'

class Main extends Component {
  constructor(props) {
    super(props);
    this.state = {
      catFacts: []
    };
    this.getData = this.getData.bind(this)
  }

  componentDidMount(){
    this.getData()
  }

  getData(){
    fetch('https://cat-fact.herokuapp.com/facts/random?animal=cat&amount=10')
    .then(res => res.json())
    .then(data => this.setState({catFacts: data}))
  }

  render() {
    return (
      <>
      <div className="facts-btn" >
      <button onClick={this.getData}>Get More Fun Facts</button>
      </div>
      <FactBox facts={this.state.catFacts}/>
      </>
    );
  }

}

export default Main;
