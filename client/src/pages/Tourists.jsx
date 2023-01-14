import React from 'react'
import { Link } from 'wouter'

import TouristCard from '../components/TouristCard'
import Details from '../components/Details'

const Tourists = () => {
  const [tourists, setTourists] = React.useState([])
  const [showDetails, setShowDetails] = React.useState(false)
  const [id, setId] = React.useState(0)

  React.useEffect(() => {
    fetch('http://localhost:8080/tourists')
      .then(response => response.json())
      .then(setTourists)
  }, [])

  return (
    <main>
      {
        tourists.map(tourist => <TouristCard key={tourist.id} setId={setId} setShowDetails={setShowDetails} tourist={tourist} />)
      }
      <Link href="/create/tourist">
        <a>Añadir turista</a>
      </Link>
      {
        showDetails && <Details details="tourists" id={id} setShowDetails={setShowDetails}/>
      }
    </main>
  )
}

export default Tourists
