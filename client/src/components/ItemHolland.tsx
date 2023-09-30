import React from 'react'
import { Holland } from '../interfaces/Holland'
import { Paper } from '@mui/material'

type ItemHollandProps = {
    data: Holland
}

const ItemHolland: React.FC<ItemHollandProps> = ({ data }) => {
  return (
    <Paper key={data.id} elevation={2}>
        <div className='w-full h-fit rounded-md overflow-hidden'>
            <img className='w-full h-fit' src={data.image} alt="holland-img" />
            <div className='p-3'>
                <div className='flex items-center gap-x-3'>
                    <p className='w-10 h-10 flex justify-center items-center rounded-lg text-xl text-white bg-primary'>{data.abbreviation}</p>
                    <p className='font-semibold'>{data.title}</p>
                </div>
            </div>
        </div>
    </Paper>
  )
}

export default ItemHolland