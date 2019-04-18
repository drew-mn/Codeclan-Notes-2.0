import React from 'react';
import Munro from './Munro';

const RegionBox = ({munros}) => {

  const munroNodes = munros.map(munro =>{
    return <Munro key={munro.name} munro={munro} />
  })

  return(
    <div>
      {munroNodes}
    </div>
  )



};

export default RegionBox;
