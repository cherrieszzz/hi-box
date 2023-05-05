import React from 'react'
import { useState } from 'react'

export default function LoginForm({onLogin}) {
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const [error, setError] = useState('')
    const [loading, setLoading] = useState(false)

    return (
        <div >
            <form onSubmit={onLogin}>
                <div >
                    <label htmlFor="email">邮箱</label>
                    <input type="email" name="email" id="email" />
                </div>
                <div >
                    <label htmlFor="password">密码</label>
                    <input type="password" name="password" id="password" />
                </div>
                <div>
                    <button type="submit" >登陆</button>
                </div>
            </form>
        </div>
    )
}
