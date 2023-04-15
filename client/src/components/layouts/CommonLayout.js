import React from 'react'
import Navbar from '../common/Navbar'
import styles from './Layout.module.css'

export default function CommonLayout({ children }) {
    return (
        <>
            <Navbar />
            <div className={styles.container}>
                {children}
            </div>
        </>
    )
}
