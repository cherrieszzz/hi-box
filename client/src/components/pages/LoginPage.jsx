import React from 'react'
import SignLayout from '../layouts/SignLayout'
import LoginForm from '../forms/LoginForm'
import LoginPicture from '../sections/LoginPicture'
import LoginTestError from '../models/LoginTestError'

export default function LoginPage() {

  const [loginError, setLoginError] = React.useState(false)

  const handleLogin = (e) => {
    e.preventDefault();
    setLoginError(true)
  }

  if(loginError) return (
    <SignLayout>
      <LoginTestError />
    </SignLayout>
  )

  return (
    <SignLayout>
       <LoginForm onLogin={handleLogin}/>
    </SignLayout>
  )
}
