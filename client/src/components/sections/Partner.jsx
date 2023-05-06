import React from 'react'
import haut_logo from '../../assets/haut_logo.png'
import zzuli_logo from '../../assets/zzuli_logo.jpg'
import hati_logo from '../../assets/hati_logo.png'
import pony_logo from '../../assets/pony_logo.jpg'
import styles from './Partner.module.css'

function PartnerCard ({ partner }) {
    return (
        <div className={styles.partner_card}>
            <img src={partner.img} alt={partner.name} />
        </div>
    )
}

export default function Partner() {
    const partnerData = [
        {
            name:'haut',
            img : haut_logo,
        },
        {
            name:'zzuli',
            img : zzuli_logo,
        },
        {
            name:'pony',
            img : pony_logo,
        },
        {
            name:'hati',
            img : hati_logo
        }
    ]

    return (
        <div className={styles.partner}>
            <h2>合作伙伴</h2>
            <div className={styles.partner_container}>
                {
                    partnerData.map(( partner ) => {
                        return (
                            <PartnerCard partner={partner} />
                        )
                    })
                }
            </div>
           
        </div>
    )
}
