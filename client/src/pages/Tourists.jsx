import React from 'react'
import { Link } from 'wouter'

import TouristCard from '../components/TouristCard'

const Tourists = () => {
  const [tourists, setTourists] = React.useState([])

  React.useEffect(() => {
    fetch('http://localhost:8080/tourists')
      .then(response => response.json())
      .then(setTourists)
  }, [])

  return (
    <main>
      {
        tourists.map(tourist => <TouristCard key={tourist.id} tourist={tourist} />)
      }
      <Link href="/create/tourist">
        <a>Añadir turista</a>
      </Link>
    </main>
  )
}

export default Tourists
