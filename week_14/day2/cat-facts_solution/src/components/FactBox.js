import React from 'react';
import Fact from './Fact';
import './FactBox.css';

const FactBox = ({facts}) => {

  const factNodes = facts.map(fact => {
    return (
      <Fact key={fact._id} fact={fact} />
    )
  })

  return (
    <div className="fact-box">
      {factNodes}
    </div>
  )

}

export default FactBox;
