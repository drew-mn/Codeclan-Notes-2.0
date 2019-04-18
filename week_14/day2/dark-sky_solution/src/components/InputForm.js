import React, { Component } from 'react';

class InputForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      lat: '',
      lng: ''
    };
    this.handleLatInput = this.handleLatInput.bind(this)
    this.handleLngInput = this.handleLngInput.bind(this)
    this.handleFormSubmit = this.handleFormSubmit.bind(this)
  }

  handleLatInput(event){
    this.setState({lat: event.target.value})
  }

  handleLngInput(event){
    this.setState({lng: event.target.value})
  }

  handleFormSubmit(event){
    event.preventDefault()
    const lat = this.state.lat.trim()
    const lng = this.state.lng.trim()
    if(!lat || !lng) return;
    this.props.handleInput({lat, lng})
    this.setState({lat: '', lng: ''})
  }

  render() {
    return (
      <form onSubmit={this.handleFormSubmit}>
        <input
          type="number"
          placeholder="latitude"
          value={this.state.lat}
          onChange={this.handleLatInput}
        />
        <input
          type="number"
          placeholder="longitude"
          value={this.state.lng}
          onChange={this.handleLngInput}
          />
        <input type="submit" value="search weather" />
      </form>
    );
  }

}

export default InputForm;
