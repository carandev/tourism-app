import React from 'react'

const TravelCard = ({ travel }) => {
  return (
    <div>
      <h4>{travel.destination.name}</h4>
      <p>{travel.travelDate}</p>
      <button>Cancelar viaje</button>
    </div>
  )
}

export default TravelCard
