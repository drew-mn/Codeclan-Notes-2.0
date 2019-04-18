import React from 'react'
import { Modal, View, Text, Button, StyleSheet } from 'react-native';

const CountryDetail = ({country, onModalClosed}) => {

  let modalContent = null

  if(country){
    modalContent = (
      <>
      <Text style={styles.name}>{country.name}</Text>
      <Text style={styles.subContent}>Capital: {country.capital}</Text>
      <Text style={styles.subContent}>Population: {country.population}</Text>
      </>
    )
  }

  return (
    <Modal visible={country !== null}>
    <View style={styles.modalContainer}>
    {modalContent}
    </View>
    <Button title="Close" onPress={onModalClosed}/>
    </Modal>
  )
}

const styles = StyleSheet.create({
  modalContainer: {
    paddingTop: 40,
    margin: 50
  },
  name: {
    fontWeight: 'bold',
    fontSize: 30,
    textAlign: 'center'
  },
  subContent: {
    fontSize: 20,
    textAlign: 'center',
    marginTop: 10
  },
})

export default CountryDetail
