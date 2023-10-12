import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'

import { HollandResultPage, HomePage, LandingPage, LoginPage, MakeSurveyPage, RegisterPage, SurveyStarterPage } from './pages'

const App: React.FC = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<LandingPage />} />
        <Route path='/login' element={<LoginPage />} />
        <Route path='/register' element={<RegisterPage />} />
        <Route path='/home' element={<HomePage />} />
        <Route path='/surveys/:surveyId' element={<SurveyStarterPage />} />
        <Route path='/surveys/:surveyId/quiz' element={<MakeSurveyPage />} />
        <Route path='/surveys/result' element={<HollandResultPage />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App