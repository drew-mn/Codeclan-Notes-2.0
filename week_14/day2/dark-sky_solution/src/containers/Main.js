import React, { Component } from 'react';
import InputForm from '../components/InputForm';
import WeatherInfoBox from '../components/WeatherInfo';
import './Main.css'

class Main extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: []
    };
    this.handleFormInput = this.handleFormInput.bind(this)
    this.getData = this.getData.bind(this)
  }

  handleFormInput(latlng){
    this.getData(latlng)
  }

  getData(latlng){
    let lat = latlng.lat
    let lng = latlng.lng
    fetch(`https://api.darksky.net/forecast/9ba968aba945b3577b3c75bb674dcfbd/${lat},${lng}`)
    .then(res => res.json())
    .then(data => this.setState({data: data.daily.data}))
  }

  render() {
    return (
      <>
      <h2 className="header">Enter location latitude and longitude for weeks weather info</h2>
      <p className="latlng-hint">Eg. London: 51.507351, -0.127758</p>
      <div className="latlng-link">
      <a href="https://www.latlong.net/">Find your latlng</a>
      </div>
      <InputForm handleInput={this.handleFormInput}/>
      <WeatherInfoBox data={this.state.data} />
      </>
    );
  }

}

export default Main;
