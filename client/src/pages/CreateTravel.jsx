import React from 'react'
import { useLocation } from 'wouter'

const CreateTravel = ({params}) => {
  const [cities, setCities] = React.useState([])
  const [travel, setTravel] = React.useState({})
  const [location, setLocation] = useLocation()

  React.useEffect(() => {
    fetch('http://localhost:8080/cities')
      .then(response => response.json())
      .then(setCities)
  }, [])
  

  const handleSubmit = async event => {
    event.preventDefault()

    console.log(params.id)
    const finalTravel = {...travel, touristId: params.id}

    console.log(finalTravel)

    const getResponse = await fetch(`http://localhost:8080/travels/${travel.cityId}/${travel.travelDate}`)
    let sendRequest = false

    const travelResponse = await getResponse.text()

    if (travelResponse){
      const responseTravel = JSON.parse(travelResponse)

      if (responseTravel.tourists.length < 5){
        sendRequest = true
      } else {
        sendRequest = false
      }
    }


    if (sendRequest) {

      const response = await fetch('http://localhost:8080/travels', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(finalTravel)
      })

      if (response.ok) setLocation('/tourists')
    } else {
      alert("No hay cupo para este día en esa ciudad")
    }

  }

  const handleInputChange = event => {
    let { name, value } = event.target

    const newTravel = { ...travel }

    if (name === 'card') value = event.target.checked

    newTravel[name] = value

    setTravel(newTravel)
  }

  return (
    <form>
      <input type="date" name="travelDate" onChange={handleInputChange}/> 
      <select name='cityId' onChange={handleInputChange}>
        <option value="">Seleccione una ciudad</option> 
        {cities.map(city =>
          <option key={city.id} value={city.id}>{city.name}</option>
        )}
      </select>
      <button onClick={handleSubmit}>Agregar viaje</button>
    </form>
  )
}

export default CreateTravel
