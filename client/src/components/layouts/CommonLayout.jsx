import React from 'react'
import Navbar from '../common/Navbar'
import Footer from '../common/Footer'

export default function CommonLayout({ children }) {
    return (
        <>
            <Navbar />
            <div className='mt-[20vh] mb-[10vh] max-w-[80rem] mx-auto min-h-[50rem]'>
                {children}
            </div>
            <Footer />
        </>
    )
}
