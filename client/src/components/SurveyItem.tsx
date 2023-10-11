import React from 'react'
import { Survey } from '../interfaces/Survey'
import { Button, Paper } from '@mui/material'

type SurveyItemProps = {
    survey: Survey
}

const SurveyItem: React.FC<SurveyItemProps> = ({ survey }) => {
  return (
    <Paper className='h-36 flex flex-col justify-start p-4 gap-4' elevation={3}>
        <p className='text-md font-semibold'>{survey.title}</p>
        <Button className='w-fit' variant='contained' disableElevation>Bắt đầu</Button>
    </Paper>
  )
}

export default SurveyItem