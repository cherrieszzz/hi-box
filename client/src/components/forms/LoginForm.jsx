import React from 'react'
import { useState } from 'react'

export default function LoginForm({onLogin}) {
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const [error, setError] = useState('')
    const [loading, setLoading] = useState(false)

    return (
        <div className='container flex items-center w-auto mx-auto'>
            <form onSubmit={onLogin} className='flex flex-col space-y-2 items-center border-2 rounded-lg p-3'>
                <h2 className='text-3xl'>登录</h2>
                <div className='space-x-2'>
                    <label htmlFor="email">邮箱</label>
                    <input className='p-1' type="email" name="email" id="email" />
                </div>
                <div className='space-x-2'>
                    <label htmlFor="password">密码</label>
                    <input className='p-1' type="password" name="password" id="password" />
                </div>
                <div>
                    <button type="submit" className='border-2 rounded-lg p-2'>登陆</button>
                </div>
            </form>
        </div>
    )
}
