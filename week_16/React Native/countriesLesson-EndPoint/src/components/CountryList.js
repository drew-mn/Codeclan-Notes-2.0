import React from 'react';
import { FlatList, Text, StyleSheet } from 'react-native';
import ListItem from './ListItem';

const CountryList = (props) => {


  return (
    <FlatList
      style={styles.listContainer}
      data={props.countries}
      renderItem={(element) => (
        <ListItem
        country={element.item}
        onItemPressed={() => props.onItemPressed(element.index)}
        />
      )}
      keyExtractor={(item) => item.name}
    />
  )
};

const styles = StyleSheet.create({
  listContainer: {
    width: '100%'
  }
})

export default CountryList;
