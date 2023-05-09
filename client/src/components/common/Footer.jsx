import React, { Component } from 'react';
import Logo from '../../assets/logo-simple.png'

export default function Footer() {
    return (
        <div className='flex w-full min-h-[10rem] justify-center items-center text-white-300 bg-gray-200'>

            <div className='flex flex-col justify-center items-center space-y-[2rem]'>
                <div>
                    <img src={Logo} alt="" className='max-h-[3rem]'/>
                </div>

                <div className='text-1xl font-serf'>
                    Copyright © 2023 HiBox Team.
                </div>
            </div>

        </div>
    )
}