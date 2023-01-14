import React from 'react'

const CityCard = ({ city, setShowDetails, setId }) => {
  const handleClick = () => {
    setShowDetails(true)
    setId(city.id)
  }

  return (
    <div onClick={handleClick}>
      <h3>{city.name}</h3>
      <p>Cantidad de habitantes: {city.population}</p>
      <p>Sitio más turistico: {city.touristAttraction}</p>
      <p>Hotel más reservado: {city.moreReservedHotel}</p>
    </div>
  )
}

export default CityCard
