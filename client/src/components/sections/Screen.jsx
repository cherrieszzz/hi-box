import React from 'react'

export default function Screen() {
  return (
    <div className='flex flex-col items-center space-y-3'>
      <h1 className='flex flex-col items-center'>
        <span className='text-7xl font-black bg-clip-text text-transparent bg-gradient-to-r from-green-400 to-blue-500'>Hi Box</span>
        <br />
        <p className=' text-7xl font-black'>你的私人健康管理专家</p>
      </h1>
      <p className='text-2xl text-gray-600 mt-2'>交互式健康交流社群</p>

      <div className='pt-3 space-x-10 mt-6'>
        <a className='border-2 p-2 rounded-lg'>注册</a>
        <a href='/login' className='border-2 p-2 rounded-lg ring-2 hover:bg-green-300'>登陆</a>
      </div>
    </div>
  )
}
