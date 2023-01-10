import React from 'react'
import { Link } from 'wouter'

import CityCard from '../components/CityCard'

const Cities = () => {
  const [cities, setCities] = React.useState([])

  React.useEffect(() => {
    fetch('http://localhost:8080/cities')
      .then(response => response.json())
      .then(setCities)
  }, [])

  return (
    <main>
      {
        cities.map(city => <CityCard key={city.id} city={city} />)
      }
      <Link href="/create/city">
        <a>Añadir ciudad</a>
      </Link>
    </main>
  )
}

export default Cities
