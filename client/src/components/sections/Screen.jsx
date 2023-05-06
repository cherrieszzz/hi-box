import React from 'react'

export default function Screen() {
  return (
    
      <div className='flex flex-col items-center'>
        <h1 className='flex flex-col items-center'>
          <span className='text-7xl'>Hi Box</span>
          <br />
          <p>你的私人健康管理专家</p>
        </h1>
        <p>交互式健康交流社群</p>
        <div className='pt-3 space-x-3'>
          <a>注册</a>
          <a href='/login' className='border-2 p-2 rounded-lg'>登陆</a>
        </div>
      </div>
  )
}
