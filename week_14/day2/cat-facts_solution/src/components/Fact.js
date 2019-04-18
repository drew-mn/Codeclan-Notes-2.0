import React from 'react';

const Fact = ({fact}) => (
  <div className="fact-card">
    <p>{fact.text}</p>
  </div>
);

export default Fact;
