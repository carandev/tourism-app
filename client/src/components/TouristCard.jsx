import React from 'react'

const TouristCard = ({ tourist, setId, setShowDetails }) => {
  const handleClick = () => {
    setShowDetails(true)
    setId(tourist.id)
  }

  return (
    <div onClick={handleClick}>
      <h3>{tourist.name}</h3>
      <p>Fecha de nacimiento: {tourist.birthDate}</p>
      <p>Identificación: {tourist.identificationType} {tourist.identification}</p>
      <p>Frecuencia de viaje: {tourist.travelFrecuency}</p>
      <p>Presupuesto de viaje: {tourist.travelBudget}</p>
    </div>
  )
}

export default TouristCard
