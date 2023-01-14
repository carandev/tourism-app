import React from 'react'
import { Link } from 'wouter'

import CityCard from '../components/CityCard'
import Details from '../components/Details'

const Cities = () => {
  const [cities, setCities] = React.useState([])
  const [showDetails, setShowDetails] = React.useState(false)
  const [id, setId] = React.useState(0)

  React.useEffect(() => {
    fetch('http://localhost:8080/cities')
      .then(response => response.json())
      .then(setCities)
  }, [showDetails])

  return (
    <main>
      {
        cities.map(city => <CityCard key={city.id} city={city} setId={setId} setShowDetails={setShowDetails} />)
      }
      <Link href="/create/city">
        <a>Añadir ciudad</a>
      </Link>
      {
        showDetails && <Details details="cities" id={id} setShowDetails={setShowDetails}/>
      }
    </main>
  )
}

export default Cities
