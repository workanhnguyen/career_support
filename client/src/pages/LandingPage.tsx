import React from 'react'
import { Container } from '@mui/material';
import { Header, HollandIntroduce, MainIntro } from '../components';

const LandingPage: React.FC = () => {
  return (
    <div className='mb-5'>
      <Container>
          <Header />
          <MainIntro />
          <HollandIntroduce />
      </Container>
    </div>
  )
}

export default LandingPage;