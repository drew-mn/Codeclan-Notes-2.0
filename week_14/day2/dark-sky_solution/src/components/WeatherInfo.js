import React from 'react';
import Day from './Day';

const WeatherInfoBox = ({data}) => {

  if(!data) return null;

  const days = data.map(day => {
    return <Day key={day.time} details={day}/>
  })

  return (
    <div className="weather-infobox">
      {days}
    </div>
  )
};

export default WeatherInfoBox;
