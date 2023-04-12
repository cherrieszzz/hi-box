import React from 'react'
import logo from '../assets/logo-simple.png'

export default function Screen() {
  return (
    <div className='screen'>
         <h1 className='yellow-green-title'>Hi Box</h1>
         <h1>你的私人健康管理专家</h1>
         <div className='screen-btn-group'>
                <button className='screen-btn'>注册</button>
                <button className='screen-btn'>登陆</button>
         </div>
    </div>
  )
}
