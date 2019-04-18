import React from 'react';

const UpdatePirateForm = (props) => {
  if(!props.pirate) return null

  function handleSubmit(event){
    event.preventDefault()
    const pirate = {
      "id": props.pirate.id,
      "firstName": event.target.firstName.value,
      "lastName": event.target.lastName.value,
      "age": event.target.age.value,
      "ship": event.target.ship.value
    }
    props.handlePirateUpdate(pirate)
  }


    const shipOptions = props.ships.map((ship) => {
      return <option key={ship.id} value={ship._links.self.href}>{ship.name}</option>
    })

    return (
      <form onSubmit={handleSubmit}>
      <input type="text" placeholder="First Name" name="firstName" defaultValue={props.pirate.firstName}/>
      <input type="text" placeholder="Last Name" name="lastName" defaultValue={props.pirate.lastName}/>
      <input type="number" placeholder="Age" name="age" defaultValue={props.pirate.age}/>
      <select name="ship">
        {shipOptions}
      </select>

      <button type="submit">Save</button>
      </form>
    )
}

export default UpdatePirateForm
