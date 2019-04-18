import React  from 'react';
import {Link} from 'react-router-dom';

const SinglePirate = (props) => {


  if(!props.pirate){
    return null;
  }

  return (
    <div className="component">
        <p>
          {props.pirate.firstName} {props.pirate.lastName}
        </p>
      <p>Age: {props.pirate.age}</p>
      <p>Ship: {props.pirate.ship.name}</p>
    </div>
  )
}

export default SinglePirate;
