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
            <div className='group relative w-full h-fit'>
                <img className='w-full h-full' src={data.image} alt="holland-img" />
                <p className='absolute z-10 hidden w-full h-full text-lg text-white text-justify top-0 p-3 group-hover:block hover:bg-black/60 hover:transition hover:duration-300'>{data.description}</p>
            </div>
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