import React, {Component} from 'react';
import PirateList from '../../components/pirates/PirateList.js';


class PirateContainer extends Component {
  constructor(props){
    super(props);
    this.state = {pirates: []}
  }


  render(){
    return (
        <div>I'm a pirate container</div>
    );
  }
}

export default PirateContainer;
