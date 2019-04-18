import React from 'react';
import { View, Text, TouchableOpacity, StyleSheet } from 'react-native';

const ListItem = ({country, onItemPressed}) => (

  <TouchableOpacity onPress={onItemPressed}>
    <View style={styles.listItem}>
      <Text>{country.name}</Text>
    </View>
  </TouchableOpacity>
)

const styles = StyleSheet.create({
  listItem: {
    width: '100%',
    marginBottom: 5,
    padding: 10,
    backgroundColor: '#eee'
  }
})

export default ListItem
