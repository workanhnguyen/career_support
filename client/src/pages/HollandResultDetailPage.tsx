import { Container } from '@mui/material';
import React from 'react'
import { useParams } from 'react-router-dom'
import { Header } from '../components';

const HollandResultDetailPage: React.FC = () => {
  const { responseId } = useParams(); 
  return (
    <Container>
      <Header />
    </Container>
  )
}

export default HollandResultDetailPage