import React, { Component } from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import NavBar from './NavBar.js'

import PirateContainer from './containers/pirates/PirateContainer';
import SinglePirateContainer from './containers/pirates/SinglePirateContainer';
import PirateFormContainer from './containers/pirates/PirateFormContainer'
import UpdatePirateFormContainer from './containers/pirates/UpdatePirateFormContainer'

class App extends Component {
  render() {
    return (
      <div>
        <Router>
          <React.Fragment>
            <NavBar/>
            <Switch>
            <Route exact path="/pirates" component={PirateContainer} />
            <Route exact path="/pirates/new" component={PirateFormContainer} />
            <Route exact path="/pirates/update/:id" render={(props) => {
              const id = props.match.params.id
              return <UpdatePirateFormContainer id={id} />
            }} />
            <Route exact path="/pirates/:id" render={(props) => {
              const id = props.match.params.id
              return <SinglePirateContainer id={id} />
            }} />
          </Switch>
          </React.Fragment>
        </Router>
      </div>
    );
  }
}

export default App;
