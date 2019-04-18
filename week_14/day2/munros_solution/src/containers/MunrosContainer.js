import React, { Component } from 'react';
import RegionSelect from '../components/RegionSelect';
import RegionBox from '../components/RegionBox';

class MunrosContainer extends Component {
constructor() {
  super();
  this.state = {
    munros: [],
    regions: [],
    selectedRegionMunros: []
  };
  this.filterRegions = this.filterRegions.bind(this)
  this.handleSelectChange = this.handleSelectChange.bind(this)
}

componentDidMount(){
  fetch('https://munroapi.herokuapp.com/api/munros ')
  .then(res => res.json())
  .then(data => this.setState({munros: data}, this.filterRegions))
}

filterRegions(){
  const regions = this.state.munros.map(munro => {
    return munro.region;
  })
  const uniqueRegions = [...new Set(regions)]
  this.setState({regions: uniqueRegions})
}

handleSelectChange(region){
  fetch(`https://munroapi.herokuapp.com/api/munros/region/${region}`)
  .then(res => res.json())
  .then(data => this.setState({selectedRegionMunros: data}))
}

  render() {
    return (
      <>
      <RegionSelect regions={this.state.regions} onSelectChange={this.handleSelectChange}/>
      <RegionBox munros={this.state.selectedRegionMunros} />
      </>
    );
  }

}

export default MunrosContainer;
