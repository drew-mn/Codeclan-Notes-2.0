import React, { Component } from 'react';
import { View, StyleSheet } from 'react-native';
import CountryList from '../components/CountryList';
import CountryDetail from '../components/CountryDetail';

class Countries extends Component {
  constructor(props) {
    super(props);
    this.state = {
      countries: [],
      selectedCountry: null
    };
  }

  componentDidMount(){
  fetch('https://restcountries.eu/rest/v2/all')
  .then(res => res.json())
  .then(countries => this.setState({countries: countries}))
}

handleItemPressed = (index) => {
  const selectedCountry = this.state.countries[index]
  this.setState({selectedCountry})
}

onModalClosedHandler = () => {
  this.setState({selectedCountry: null})
}

  render() {
    return (
      <View style={styles.container}>
        <CountryList
          countries={this.state.countries}
          onItemPressed={this.handleItemPressed}
        />
        <CountryDetail
          country={this.state.selectedCountry}
          onModalClosed={this.onModalClosedHandler}
        />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingTop: 40,
    justifyContent: "flex-start",
    alignItems: 'center',
    backgroundColor: "#F5FCFF"
  }
})

export default Countries;
