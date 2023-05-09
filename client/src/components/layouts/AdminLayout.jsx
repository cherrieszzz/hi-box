import React, { Component } from 'react';

function SideBar () {
    return (
        <div>

        </div>
    )
}

export default function AdminLayout ({children}) {
    return (
        <div className='grid'>
            {children}
        </div>
    )
}