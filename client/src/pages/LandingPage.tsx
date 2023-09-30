import React from 'react'
import { Container } from '@mui/material';
import { Header, HollandIntroduce, ListHolland, MainIntro } from '../components';

const LandingPage: React.FC = () => {
  return (
    <Container>
      <div className='flex flex-col justify-between gap-8 mb-5'>
            <Header />
            <MainIntro />
            <HollandIntroduce />
            <ListHolland />
      </div>
    </Container>
  )
}

export default LandingPage;