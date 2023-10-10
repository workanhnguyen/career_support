import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'

import { LandingPage, LoginPage, RegisterPage } from './pages'

const App: React.FC = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<LandingPage />} />
        <Route path='/login' element={<LoginPage />} />
        <Route path='/register' element={<RegisterPage />} />
        <Route path='/register' element={<RegisterPage />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App