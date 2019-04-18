# Countries App

### Learning Objectives
- Understand basic React Native Components


## Intro
React Native lets you build mobile apps using only JavaScript.  Instead of writing Android apps in Java and IOS apps in Object C or Swift you can write code for both platforms in JavaScript, following the same concepts as React.  React Native will then compile this code in order for it to work on android and ios devices.

Its important to note that React Native is not just the case of writing on piece of code for all, what we'll be doing today is the very basics, however with more complex apps you may need to optimise certain aspects of the app and drop back down to native Java or Object C code.

## Set Up
First off lets install the dependencies that we'll need to get started with React Native.  We need to have node version 8.3 or newer

```bash
node -v
```

If that is less than 8.3 install with

```bash
brew install node
```

Facebook - the developers of React Native also recommend installing Watchman which is a tool by Facebook for watching for changes in the filesystem and so improves development performance.

```bash
brew install watchman
```

And then finally lets globally install the React Native cli so that we can easily create a new project.

```bash
npm install -g react-native-cli
```

We now need to hook this cli up with xcode.  In xcode open preferences/locations and from the dropdown next to Command Line Tools select XCode v10.1 (or whatever version your Xcode is on).

## Getting Started
To initiate a new project we run the command `react-native init [project name]`.

```bash
react-native init countriesApp
```

Lets open that in atom.

There are a lot of files in here that you don't need to worry about for the time being.  These files are essentially what compile our JavaScript code into the native code required to run on android and ios devices.

The first thing we'll do is add a script in `package.json` to run the app on our emulator.  The command to run your app on ios is `react-native run-ios`, and for android is `react-native run-android`.  For me this is too much typing so I add a script to run this command for me.

> We'll only be running on ios today as the set up for android studio is too time consuming

```js
//package.json
"scripts": {
  //as before
  "ios": "react-native run-ios"
},
```

Now to run the app all we have to do is run the command `npm run ios`.  This may take a while the first time its ran.  

```bash
npm run ios
```
A second terminal window should pop open, this is the bundler/compiler and needs to be kept running at all times.

Once loaded the emulator will show the boilerplate text which is coming from the code written in `App.js`.  Lets strip out all of that code.

> type Props={} and Component<Props> comes from Flow which is a static type checker to ensure your props are the type that you indent to use them as

```js
//App.js
import React, {Component} from 'react';


export default class App extends Component<Props> {
  render() {
    return (

    );
  }
}
```

## Creating Countries Container

Lets start writing our own code.  Create a src folder at the top level and within there a components and containers folder.

Within the containers folder touch `Countries.js` and then import that into `App.js`.

```js
//App.js
import React, {Component} from 'react';
import Countries from './src/containers/Countries'


export default class App extends Component<Props> {
  render() {
    return (
      <Countries /> //NEW
    );
  }
}
```
Now lets start building this component.  The general set up of the components in React Native are exactly the same as they are in react.  This component is going to contain state so we'll set it up as a class.

```js
//Countries.js
import React, { Component } from 'react';

class Countries extends Component {
  constructor(props) {
    super(props);
    this.state = {
      countries: []
    };
  }

  render() {
    return (

    );
  }

}

export default Countries;
```

The difference comes when we start telling the component how to render.  We can't use `divs` or other html elements here.  What we need to use is a `View` imported from React Native.  A list of all available components which can be used in React Native and their capabilities are contained within the React Native docs [https://facebook.github.io/react-native/docs].

Lets import `View` and `Text` so that we can see something rendering to the screen.

```js
//Countries.js
import React, { Component } from 'react';
import { View, Text } from 'react-native'; //NEW

//AS BEFORE
  render() {
    return (
      <View> //NEW
        <Text>Hello World!</Text>
      </View>
    );
  }

}

export default Countries;
```
Go back to the emulator, click on it and then press command+R to reload.  You should see a tiny "Hello World!" in the top left hand corner.

>React Fragments also exist in RN as <> </> but we'll keep the view here as we'll add some styling to it.

## Styling

Styling in React Native is similar to it is on the web however has slight differences in that not all of the css attributes are available and in RN we declare them in camelCase.  The values have to either be an integer or a string dependant on the attributes.  Someone has made a very helpful cheatsheet of what we can use [here]('https://github.com/vhpoet/react-native-styling-cheat-sheet').

>Flexbox flex direction default in React Native is column instead of row. So the cross axis is the x axis rather than the y axis.

To style in RN we create a JavaScript object.  First we have to pull in the `StyleSheet` component from RN and then call its create function on it.  We'll do this within a variable called styles.

```js
//Countries.js
import React, { Component } from 'react';
import { View, Text, StyleSheet } from 'react-native'; //UPDATED

//AS BEFORE
  render() {
    return (
      <View>
        <Text>Hello World!</Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({ //NEW
  container: {
    flex: 1, //tells the container to take up all of the possible width of the screen
    paddingTop: 40,
    justifyContent: "flex-start", //will align content to top of screen,
    alignItems: 'center', //centres container
    backgroundColor: "#F5FCFF"
  }
})

export default Countries;
```

To add this style to our View we do so like this:

```js
//Countries.js
<View style={styles.container}> //NEW
  <Text>Hello World!</Text>
</View>
```

If you go back and refresh your screen you should see the text a bit better now.

## LifeCycle Methods

As we are using React Components we have access to the same LifeCycle methods as we do for normal React apps.

We'll use `componentDidMount()` to pull back all of the countries and store them in state.

```js
//Countries.js
constructor(props) {
  super(props);
  this.state = {
    countries: []
  };
}

componentDidMount(){
  fetch('https://restcountries.eu/rest/v2/all')
  .then(res => res.json())
  .then(countries => this.setState({countries: countries}))
}
```

But how do we check if this has worked??? We don't have access to the React dev tools in chrome from here.  Luckily there is a desktop React dev tools app that we can install

```bash
npm install -g react-devtools
```

Now run `react-devtools` to launch the app.

Refresh the app with command+R and look in the devtools for the `Countries` component and you should see state of 250 countries at the right hand side.

## Rendering a List
With this array of countries we're going to pass it down to a list as props so that we can render a list of each name.

In components lets make CountryList.js and import it into Countries.js.  Then we'll remove the Text component and instead render the CountryList passing down the state of countries as props.  We're not using Text in this component anymore so we can remove it from the react-native import.

```js
//Countries.js
import { View, StyleSheet } from 'react-native'; //UPDATED
import CountryList from '../components/CountryList'; //NEW

render() {
  return (
    <View style={styles.container}>
      <CountryList countries={this.state.countries}/>//NEW
    </View>
  );
}
```

The component we are going to use from RN to render a list is called `FlatList`.  FlatLists are good for performance compared to a `ListView` which is now depreciated as it only renders whats on screen + a couple of components either side for scrolling.

Our CountryList is going to be a stateless functional component.

```js
//CountryList.js
import React from 'react';
import { FlatList, Text, StyleSheet } from 'react-native';

const CountryList = (props) => {

  return (
    <FlatList

    />
  )
};
```

Something that a FlatList has to have is a property of data.   This data will be our `props.countries`.

```js
//CountryList.js

const CountryList = (props) => {

  return (
    <FlatList
      data={props.countries} //UPDATED

    />
  )
};
```

And then we have to tell it what to render which takes in a function, which works like a map like we've done before when rendering components in React.

```js
//CountryList.js

const CountryList = (props) => {

  return (
    <FlatList
      data={props.countries}
      renderItem={(item) => (
        <Text>{item.item.name}</Text>
      )}
    />
  )
};
```
Here we're calling each iteration an item which in itself has its own item object which is really our country.  This looks a bit wild at the moment and will look clearer in our dev tools in a minute when we render a ListItem component.  

To access it in the dev tools we have to search for CountryList, expand FlatList, expand VirtulizedList, expand ScrollView then RCTScrollView, then RCTScrollContentView and finally click on one of the CellRenderer components and on the right hand side you will see the item object which when expanded will show details of the country.

When you refresh your emulator you should see a list of country names.  You'll see that there is also a warning about not having a key for each item so lets fix that.
To fix this we need to use the property of `keyExtractor` which is used to extract a unique key for a given item at the specified index.

We do this like

```js
//CountryList.js
<FlatList
  data={props.countries}
  renderItem={(element) => (
    <Text>{element.item.name}</Text>
  )}
  keyExtractor={(item) => item.name} //NEW
/>
```

We have to use a unique value from the object, and the value has to be a string.  So if you were using an id which was an integer you'd have to use .toString() on it.  The argument of item that we pass into the keyExtractor is the item object that the FlatList element brings us back.

## Individual Objects

Lets break the `CountryList` down a bit to render individual `ListItem`'s instead of Text components.

Create a `ListItem` component within the components folder and import it into `CountryList` where we'll replace the Text component with it and pass it the element item as props called country.

And give it some styling

```js
//CountryList.js

import { FlatList, Text, StyleSheet } from 'react-native';
import ListItem from './ListItem';//NEW

const CountryList = (props) => {

  return (
    <FlatList
      style={styles.listContainer} //NEW
      data={props.countries}
      renderItem={(element) => (
        <ListItem country={element.item} /> //UPDATED
      )}
      keyExtractor={(item) => item.name}
    />
  )
};

const styles = StyleSheet.create({ //NEW
  listContainer: {
    width: '100%'
  }
})
```

Now lets build the ListItem:

```js
//ListItem.js
import React from 'react';
import { View, Text, StyleSheet } from 'react-native';

const ListItem = ({country}) => (

    <View>
      <Text>{country.name}</Text>
    </View>
)

export default ListItem
```

If you refresh the app and look at the dev tools again, this time searching for ListItem we can see the elements item is now passed down as props as country.

Lets now style this a bit so we can create items big enough to click on:

```js
//ListItem.js
import React from 'react';
import { View, Text, StyleSheet } from 'react-native';

const ListItem = ({country}) => (

    <View style={styles.listItem}> //UPDATED
      <Text>{country.name}</Text>
    </View>
)

const styles = StyleSheet.create({ //NEW
  listItem: {
    width: '100%',
    marginBottom: 5,
    padding: 10,
    backgroundColor: '#eee'
  }
})

export default ListItem
```

## Selecting a Country

We've now got a list of country names.  Our next steps are to make those list elements clickable, passing the index back up to our country container in order to render a pop up with more details about the country.

Lets start off by making the `ListItem` touchable.  RN gives us 4 different types of Touchable components to use `TouchableHighlight`, `TouchableOpacity`, `TouchableNativeFeedback` and `TouchableWithoutFeedback`.

For this we're going to use `TouchableOpacity` so lets import that and wrap our `View` in it.

```js
//ListItem.js

import { View, Text, TouchableOpacity, StyleSheet } from 'react-native'; //UPDATED

const ListItem = ({country}) => (
  <TouchableOpacity> //NEW
    <View style={styles.listItem}>
      <Text>{country.name}</Text>
    </View>
  </TouchableOpacity>
)
```

Refresh your app, click on a country and you should now see some fading animation.

Lets think now about how we are going to pass the index of the country back up to the top level.

As we want the function to be called when we select an item we'll start off in the `ListItem` component adding an onPress to our Item.

```js
//ListItem.js


const ListItem = ({country, onItemPressed}) => (

  <TouchableOpacity onPress={onItemPressed}> //UPDATED
    <View style={styles.listItem}>
      <Text>{country.name}</Text>
    </View>
  </TouchableOpacity>
)
```

We're calling a function that we've yet to write.  Destructuring props, we're calling a function called onItemPressed when we touch that component.

Lets now write that function in `CountryList`.  When we click on an item, we want to take that index of the item and pass it back up to the top container.

To do this we can write an anonymous function within props to pass the id back up to the main container.  Lets test with an alert that we're getting back an id.

```js
//CountryList.js

return (
  <FlatList
    data={props.countries}
    renderItem={(element) => (
      <ListItem
      country={element.item}
      onItemPressed={() => alert(element.index)} //NEW
      />
    )}
    keyExtractor={(item) => item.name}
  />
)

```

Reload the app, click on an item and you should see an alert with the index pop up.

> alerts can be quite buggy and cause the app to freeze/lag

Lets change that alert to calling a function which again will come down as props from the container.

```js
//CountryList.js

onItemPressed={() => props.onItemPressed(element.index)} //UPDATED
```

And in `Countries` lets write that function and tie it all up.

```js
//Countries.js

constructor(props) {
  super(props);
  this.state = {
    countries: [],
    selectedCountry: null //UPDATED
  };
}

handleItemPressed = (index) => { //NEW
  const selectedCountry = this.state.countries[index]
  this.setState({selectedCountry})
}

render() {
  return (
    <View style={styles.container}>
      <CountryList
        countries={this.state.countries}
        onItemPressed={this.handleItemPressed} //NEW
      />
    </View>
  );
}
```

We've passed the index of the item selected back up to the top container.  Here we're using that index to find the object in that position of the countries array in state and then setting state of selected country.

If we go back to the app and refresh, open the dev tools, have the Countries container showing, select a country and you should see the selected country state change.

## Country Details

The last thing we have to do is render the details of the selected country as a popup or a modal.  This is going to set on the same level as our `CountryList`, so it was always be there, we'll just need to trigger when its visible.

Create a new file in components called `CountryDetail` and import it into the `Countries` container.

```js
//Countries.js
import CountryDetail from '../components/CountryDetail'; //NEW

//AS BEFORE

render() {
  return (
    <View style={styles.container}>
      <CountryList
        countries={this.state.countries}
        onItemPressed={this.handleItemPressed}
      />
      <CountryDetail //NEW
        country={this.state.selectedCountry}
      />
    </View>
  );
}
```

And now lets build the `CountryDetail` component.  In here we will use the Modal component given to us by RN.

```js
//CountryDetail.js
import React from 'react'
import { Modal, View, Text, Button, StyleSheet } from 'react-native';

const CountryDetail = ({country}) => {

  return (
    <Modal>
      <View style={styles.modalContainer}>
        <Text>Modal</Text>
      </View>
      <Button title="Close" />
    </Modal>
  )
}

const styles = StyleSheet.create({
  modalContainer: {
    paddingTop: 40,
    margin: 50
  }
})

export default CountryDetail
```

So we can see this quite clearly we'll give it some style so it doesn't sit sit in the top right hand corner.

If you refresh the app, you should see the modal there.  But this isn't really what we want.  We only want to see it if we've selected a country.

Lets fix that.

```js
//CountryDetail.js
const CountryDetail = ({country}) => {

  return (
    <Modal visible={country !== null}>
      <View style={styles.modalContainer}>
        <Text>Modal</Text>
      </View>
      <Button title="Close" />
    </Modal>
  )
}



export default CountryDetail
```

The Modal component comes with a property `visible`.  We've said this should only be visible if the country is not null.  So if you refresh the app and click on a country the modal should popup.

So to close the modal, all we need to do is set the state of selectedCountry back to null.  Lets do that and tie it up with the button.

```js
//Countries.js

onModalClosedHandler = () => { //NEW
  this.setState({selectedCountry: null})
}

render() {
  return (
    <View style={styles.listContainer}>
    <CountryList
      countries={this.state.countries}
      onItemSelected={this.placeSelectedHandler}
    />
    <CountryDetail
      country={this.state.selectedCountry}
      onModalClosed={this.onModalClosedHandler} //UPDATED
    />
    </View>
  );
}
```
And in CountryDetail:

```js
//CountryDetail.js

const CountryDetail = ({country, onModalClosed}) => { //UPDATED

return (
  <Modal visible={country !== null}>
    <View style={styles.modalContainer}>
      <Text>Modal</Text>
    </View>
    <Button title="Close" onPress={onModalClosed}/> //UPDATED
  </Modal>
  )   
}
```
If you refresh the app, you should now be able to open and close the modal.

The last step is to fill that modal with appropriate content.  But setting visible attribute isn't enough to handle no country being set in state.  If we try to render `{country.name}` when state is null we'll get an error.

```js
//CountryDetail.js

const CountryDetail = ({country, onModalClosed}) => {

  let modalContent = null //NEW

  if(country){ //NEW
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
      {modalContent} //UPDATED
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
  name: { //UPDATED
    fontWeight: 'bold',
    fontSize: 30,
    textAlign: 'center'
  },
  subContent: { //UPDATED
    fontSize: 20,
    textAlign: 'center',
    marginTop: 10
  },
})
```
