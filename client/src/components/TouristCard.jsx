import React from 'react'

const TouristCard = ({ tourist }) => {
  const [city, setCity] = React.useState({ name: 'test' })

  return (
    <div>
      <h3>{tourist.name}</h3>
      <p>Fecha de nacimiento: {tourist.birthDate}</p>
      <p>Identificación: {tourist.identificationType} {tourist.identification}</p>
      <p>Frecuencia de viaje: {tourist.travelFrecuency}</p>
      <p>Presupuesto de viaje: {tourist.travelBudget}</p>
      <p>Destino: {city.name}</p>
    </div>
  )
}

export default TouristCard
