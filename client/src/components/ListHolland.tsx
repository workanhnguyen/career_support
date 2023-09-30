import React from 'react'
import { useHollands } from '../hooks'
import { CircularProgress, Grid } from '@mui/material';
import { ItemHolland, Title } from '../components';

const ListHolland: React.FC = () => {
    const { hollands, isHollandLoading } = useHollands();

  return (
    <div className='w-full flex flex-col justify-center'>
        {isHollandLoading ? <CircularProgress /> : (

            <>
            <Title text='Các nhóm ngành nghề theo mật mã Holland' />
                <Grid container spacing={3}>
                    {hollands.map(holland => (
                        <Grid item xs={12} sm={6} md={4}>
                            <ItemHolland data={holland} />
                        </Grid>
                    ))}      
                </Grid>
            </>
        )}
    </div>
  )
}

export default ListHolland