import React from 'react'
import { Link } from 'wouter'

const Home = () => {
  return (
    <main>
      <h1>Aplicación de Turismo</h1>
      <Link href="/tourists">
        <a>Turistas</a>
      </Link>
      <Link href="/cities">
        <a>Ciudades</a>
      </Link>
    </main>
  )
}

export default Home
