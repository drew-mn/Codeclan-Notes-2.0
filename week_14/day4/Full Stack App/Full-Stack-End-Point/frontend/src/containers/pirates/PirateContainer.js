import React, {Component} from 'react';
import PirateList from '../../components/pirates/PirateList.js';
import Request from '../../helpers/request.js';


class PirateContainer extends Component {
  constructor(props){
    super(props);
    this.state = {
      pirates: []
    }
  }

  componentDidMount(){
    let request = new Request()
    request.get('/api/pirates').then(data => {
      this.setState({pirates: data._embedded.pirates})
    })
  }

  getPirates(){

  }


  render(){
    return (
        <PirateList pirates={this.state.pirates}/>
    );
  }
}

export default PirateContainer;
