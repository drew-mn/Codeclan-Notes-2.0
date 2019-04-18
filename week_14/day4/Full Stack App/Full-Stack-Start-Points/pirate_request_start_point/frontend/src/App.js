import React, { Component } from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import NavBar from './NavBar.js'

import PirateContainer from './containers/pirates/PirateContainer'

class App extends Component {
  render() {
    return (
      <div>
        <Router>
          <React.Fragment>
            <NavBar/>
            <Switch>
            <Route exact path="/pirates" component={PirateContainer} />
          </Switch>


          </React.Fragment>
        </Router>
      </div>
    );
  }
}

export default App;
