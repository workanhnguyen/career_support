import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'

import { HollandResultDetailPage, HollandResultPage, HomePage, LandingPage, LoginPage, MakeSurveyPage, PersonalPage, RegisterPage, SurveyStarterPage } from './pages'

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
        <Route path='/surveys/result/:responseId' element={<HollandResultDetailPage />} />
        <Route path='/profile' element={<PersonalPage />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App