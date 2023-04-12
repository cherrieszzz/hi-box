import React from 'react'
import haut_logo from '../../assets/haut_logo.png'
import zzuli_logo from '../../assets/zzuli_logo.jpg'
import hati_logo from '../../assets/hati_logo.png'
import pony_logo from '../../assets/pony_logo.jpg'
import styles from './Partner.module.css'

export default function Partner() {
    return (
        <div className={styles.partner}>
            <h2>合作伙伴</h2>
            <div className={styles.partner_container}>
            <img src={haut_logo} alt='haut' className={styles.partner_logo} />
            <img src={zzuli_logo} alt='haut' className={styles.partner_logo}/>
            <img src={pony_logo} alt='haut' className={styles.partner_logo_long}     />
            </div>
           
        </div>
    )
}
