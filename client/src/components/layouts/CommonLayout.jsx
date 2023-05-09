import React from 'react'
import Navbar from '../common/Navbar'
import Footer from '../common/Footer'

export default function CommonLayout({ children }) {
    return (
        <>
            <Navbar />
            <div className='mt-[20vh]'>
                {children}
            </div>
            <Footer />
        </>
    )
}
