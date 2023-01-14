import React from 'react'
import { Route } from 'wouter'

import { Home, Tourists, Cities, CreateCities, CreateTourists, CreateTravel } from './pages'

function App () {
  return (
    <>
      <Route component={Home} path='/' />
      <Route component={Tourists} path='/tourists' />
      <Route component={Cities} path='/cities' />
      <Route component={CreateCities} path='/create/city' />
      <Route component={CreateTourists} path='/create/tourist' />
      <Route component={CreateTravel} path='/create/travel/:id' />
    </>
  )
}

export default App
