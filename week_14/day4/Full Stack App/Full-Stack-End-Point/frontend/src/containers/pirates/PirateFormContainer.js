import React, {Component} from 'react'
import Request from '../../helpers/request.js';

import PirateForm from '../../components/pirates/PirateForm'

class PirateFormContainer extends Component {
  constructor(props){
    super(props);
    this.state = {
      ships: []
    }
    this.handlePiratePost = this.handlePiratePost.bind(this)
  }

  componentDidMount(){
    const request = new Request()
    request.get('/api/ships').then(data =>{
      this.setState({ships: data._embedded.ships})
    })
  }

  handlePiratePost(pirate){
    const request = new Request();
    request.post('/api/pirates', pirate).then(() => {
      window.location = '/pirates'
    })
  }

  handlePirateUpdate(pirate){
    const url = '/api/pirates/' + pirate.id;
    let request = new Request();
    request.put(url, pirate).then(data => {
      window.location = '/pirates'
    })
  }

  render(){
    return (
      <PirateForm ships={this.state.ships} handlePiratePost={this.handlePiratePost} />
    )
  }

}

export default PirateFormContainer
