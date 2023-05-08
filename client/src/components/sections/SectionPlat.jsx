import React, { Component } from 'react';

export default function SectionPlat() {
    return (
        <div className='flex max-w-[50rem] mx-auto my-[10rem]'>
            <div className='text-center'>
                <h2 className='font-black text-2xl'>社区交流</h2>
                <p className='text-gray-500'>
                    Builds on top of standard HTML, CSS and JavaScript with intuitive API and world-class documentation.
                </p>
            </div>
            <div className='text-center'>
                <h2 className='font-black text-2xl'>
                    私人定制
                </h2>
                <p className='text-gray-500'>
                    Truly reactive, compiler-optimized rendering system that rarely requires manual optimization.
                </p>
            </div>
            <div className='text-center'>
                <h2 className='font-black text-2xl'>
                    科普专栏
                </h2>
                <p className='text-gray-500'>
                    A rich, incrementally adoptable ecosystem that scales between a library and a full-featured framework.
                </p>
            </div>
        </div>
    )
}