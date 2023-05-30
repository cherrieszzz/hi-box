import React from 'react'
import Navbar from '../common/Navbar'
import Footer from '../common/Footer'

export default function BigDataLayout({ children }) {
    return (
        <>
            <Navbar />
            <div className='mt-[4rem]'>
                {children}
            </div>
            <Footer />
        </>
    )
}