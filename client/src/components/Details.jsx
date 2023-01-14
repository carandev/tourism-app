import React from 'react'
import TravelCard from './TravelCard'

const Details = ({ id, details, setShowDetails }) => {
  const [entity, setEntity] = React.useState({})
  const [travels, setTravels] = React.useState([])

  React.useEffect(() => {
    fetch(`http://localhost:8080/${details}/${id}`)
      .then(response => response.json())
      .then(setEntity)

    if (details === 'tourists') {
      fetch(`http://localhost:8080/travels/tourists/${id}`)
        .then(response => response.json())
        .then(setTravels)
    }
  }, [id, details])

  const handleDelete = async () => {
    const response = await fetch(`http://localhost:8080/${details}/${id}`, {
      method: 'DELETE'
    })

    if (response.ok) {
      setShowDetails(false)
    } else {
      alert('Hay viajes relacionados con esta información')
    }
  }

  return (
    <div>
      <div>{entity.name}</div>
      <button>Editar</button>
      <button onClick={handleDelete}>Eliminar</button>
      {
        details === 'tourists' && (
              <div>
                {
                  travels.map(travel => <TravelCard key={travel.id} travel={travel}/>)
                }
                <a href={`/create/travel/${id}`}>Agregar viaje</a>
              </div>
          )
      }

    </div>
  )
}

export default Details
