import React, { Component } from 'react';

function SideBar () {
    return (
        <div className='h-full'>
            <h1 className='text-2xl font-black max-w-full mx-auto'>控制台</h1>
        </div>
    )
}

export default function AdminLayout ({children}) {
    return (
        <div className='grid grid-cols-6 h-screen'>
            <div className='col-span-1 bg-gray-50 shadow-lg'>
                <SideBar />
            </div>

            <div className='col-span-5'>
                {children}
            </div>
        </div>
    )
}