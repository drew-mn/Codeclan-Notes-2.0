import React, {Component} from 'react';
import SinglePirate from '../../components/pirates/SinglePirate.js';

import Request from '../../helpers/request.js';

class SinglePirateContainer extends Component {
  constructor(props){
    super(props);
  }
    render(){
    return (
       <p>I am a SinglePirateContainer</p>
    )
  }
}

export default SinglePirateContainer;
