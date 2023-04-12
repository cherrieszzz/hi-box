import React from 'react'
import logo from '../assets/logo-simple.png'

export default function Screen() {
  return (
    <div className='screen'>
         <h1>
          <span  className='yellow-green-title'>Hi Box</span> 
          <br/>
         你的私人健康管理专家</h1>
         <p className='description'>交互式健康交流社群</p>
         <div className='screen-btn-group'>
                <a className='screen-btn green'>注册</a>
                <a className='screen-btn'>登陆</a>
         </div>
    </div>
  )
}
