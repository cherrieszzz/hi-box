import React from 'react'
import { useState } from 'react'
import styles from './LoginForm.module.css'

export default function LoginForm({onLogin}) {
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const [error, setError] = useState('')
    const [loading, setLoading] = useState(false)

    return (
        <div className={styles.login_form}>
            <form onSubmit={onLogin}>
                <div className={styles.form_group}>
                    <label htmlFor="email">邮箱</label>
                    <input type="email" name="email" id="email" />
                </div>
                <div className={styles.form_group}>
                    <label htmlFor="password">密码</label>
                    <input type="password" name="password" id="password" />
                </div>
                <div className={styles.form_group}>
                    <button type="submit" className={styles.login_btn}>登陆</button>
                </div>
            </form>
        </div>
    )
}
