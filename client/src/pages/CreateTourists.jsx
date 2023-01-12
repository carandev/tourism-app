import React from 'react'
import { useLocation } from 'wouter'

const CreateTourists = () => {
  const [tourist, setTourist] = React.useState({
    name: '',
    birthDate: '',
    identification: '',
    identificationType: '',
    cityId: '',
    travelFrecuency: 0,
    travelBudget: '',
    card: false
  })
  const [cities, setCities] = React.useState([])
  const [_, setLocation] = useLocation()

  React.useEffect(() => {
    fetch('http://localhost:8080/cities')
      .then(response => response.json())
      .then(setCities)
  }, [])

  const handleSubmit = async event => {
    event.preventDefault()

    const response = await fetch('http://localhost:8080/tourists', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json;charset=utf-8'
      },
      body: JSON.stringify(tourist)
    })

    if (response.ok) setLocation('/tourists')
  }

  const handleInputChange = event => {
    let { name, value } = event.target

    const newCity = { ...tourist }

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
      <select name="cityId" onChange={handleInputChange}>
        <option value="">Seleccione una ciudad</option>
        {cities.map(city =>
          <option key={city.id} value={city.id}>{city.name}</option>
        )}
      </select>
      <button type="submit">Agregar</button>
    </form>
  )
}

export default CreateTourists
