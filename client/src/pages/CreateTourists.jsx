import React from 'react'
import { useLocation } from 'wouter'

const CreateTourists = () => {
  const [tourist, setTourist] = React.useState({
    name: '',
    birthDate: '',
    identification: '',
    identificationType: '',
    travelFrecuency: 0,
    travelBudget: '',
    card: false
  })
  const [_, setLocation] = useLocation()

  const handleSubmit = event => {
    event.preventDefault()

    fetch('http://localhost:8080/tourists', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json;charset=utf-8'
      },
      body: JSON.stringify(tourist)
    }).then(response => response.ok && setLocation('/tourists'))
  }

  const handleInputChange = event => {
    let { name, value } = event.target

    const newCity = { ...tourist }

    if (name === 'travelFrecuency') value = parseInt(value)

    if (name === 'travelBudget') value = parseFloat(value)

    if (name === 'card') value = event.target.checked

    newCity[name] = value

    setTourist(newCity)
  }

  return (
    <form onSubmit={handleSubmit}>
      <input name="name" type="text" value={tourist.name} onChange={handleInputChange} />
      <input name="birthDate" type="date" value={tourist.birthDate} onChange={handleInputChange} />
      <input name="identification" type="text" value={tourist.identification} onChange={handleInputChange} />
      <input name="identificationType" type="text" value={tourist.identificationType} onChange={handleInputChange} />
      <input name="travelFrecuency" type="number" value={tourist.travelFrecuency} onChange={handleInputChange} />
      <input name="travelBudget" type="text" value={tourist.travelBudget} onChange={handleInputChange} />
      <input name="card" type="checkbox" onChange={handleInputChange} />
      <button type="submit">Agregar</button>
    </form>
  )
}

export default CreateTourists
