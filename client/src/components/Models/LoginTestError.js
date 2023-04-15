import React from 'react'
import style from './LoginTestError.module.css'

export default function LoginTestError() {
  return (
    <div className={style.login_test_error}>
        <h1>登陆失败</h1>
        <p>该功能正在测试</p>
    </div>
  )
}
