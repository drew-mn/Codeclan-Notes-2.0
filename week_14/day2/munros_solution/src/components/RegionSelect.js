import React from 'react';

const RegionSelect = (props) => {

  const options = props.regions.map(region => {
    return <option value={region} key={region}>{region}</option>
  })

  function handleChange(event){
    props.onSelectChange(event.target.value)
  }

  return (
    <select onChange={handleChange}>
      <option>Select Region...</option>
      {options}
    </select>
  )
};

export default RegionSelect;
