import { Container } from '@mui/material'
import React from 'react'
import { Footer, Header, MainContent } from '../components'

const HomePage = () => {
  return (
    <>
      <Container>
        <div className="flex flex-col justify-between gap-8 mb-5">
          <Header />
          <MainContent />
        </div>
      </Container>
      <Footer />
    </>
  )
}

export default HomePage