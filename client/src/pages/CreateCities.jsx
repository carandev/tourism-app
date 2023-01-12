import React from 'react'
import { useLocation } from 'wouter'

const CreateCities = () => {
  const [city, setCity] = React.useState({
    name: '',
    population: 0,
    touristAttraction: '',
    moreReservedHotel: ''
  })
  const [_, setLocation] = useLocation()

  const handleSubmit = async event => {
    event.preventDefault()

    const response = await fetch('http://localhost:8080/cities', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json;charset=utf-8'
      },
      body: JSON.stringify(city)
    })

    if (response.ok) setLocation('/cities')
  }

  const handleInputChange = event => {
    const { name, value } = event.target

    const newCity = { ...city }

    newCity[name] = value

    setCity(newCity)
  }

  return (
    <form onSubmit={handleSubmit}>
      <input name="name" type="text" value={city.name} onChange={handleInputChange} />
      <input name="population" type="number" value={city.population} onChange={handleInputChange} />
      <input name="touristAttraction" type="text" value={city.touristAttraction} onChange={handleInputChange} />
      <input name="moreReservedHotel" type="text" value={city.moreReservedHotel} onChange={handleInputChange} />
      <button type="submit">Agregar</button>
    </form>
  )
}

export default CreateCities
