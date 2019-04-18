import React, {Component} from 'react'
import Request from '../../helpers/request.js';

import UpdatePirateForm from '../../components/pirates/UpdatePirateForm'

class UpdatePirateFormContainer extends Component {
  constructor(props){
    super(props);
    this.state = {
      ships: [],
      pirate: null
    }
    this.handlePirateUpdate = this.handlePirateUpdate.bind(this)
    this.getShips = this.getShips.bind(this)
    this.getPirate = this.getPirate.bind(this)
  }

  componentDidMount(){
    this.getShips()
    this.getPirate()
  }

  getShips(){
    const request = new Request()
    request.get('/api/ships').then(data =>{
      this.setState({ships: data._embedded.ships})
    })
  }

  getPirate(){
    let request = new Request()
    const url = '/api/pirates/' + this.props.id + '?projection=embedShip'
    request.get(url).then(data => {
      this.setState({pirate: data})
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
      <UpdatePirateForm
        ships={this.state.ships}
        handlePirateUpdate={this.handlePirateUpdate}
        pirate={this.state.pirate}
      />
    )
  }

}

export default UpdatePirateFormContainer
