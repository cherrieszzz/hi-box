import React from 'react'
import styles from './Layout.module.css'

export default function SignLayout({ children }) {
  return (
    <div className={styles.sign_container}>
      {children}
    </div>
  )
}
