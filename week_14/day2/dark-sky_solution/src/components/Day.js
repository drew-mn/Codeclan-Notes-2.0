import React from 'react';
import moment from 'moment'


const Day = (props) => {

  if(!props.details) return null;

  const {time, summary} = props.details

  const parsedTime = moment.unix(parseInt(time)).format('dddd, MMMM Do, YYYY h:mm:ss A')

  return (
    <div className="daily-info">
    <h3>{parsedTime}</h3>
    <p>{summary}</p>
    </div>

  )

};

export default Day;
