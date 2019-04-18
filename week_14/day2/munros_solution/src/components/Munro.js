import React from 'react';

const Munro = ({munro}) => (
  <div>
  <h3>{munro.name}</h3>
  <p>Height: {munro.height}</p>
  <p>Meaning: {munro.meaning}</p>
  </div>
);

export default Munro;
