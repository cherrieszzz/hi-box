import React from 'react'
import haut_logo from '../../assets/haut_logo.png'
import zzuli_logo from '../../assets/zzuli_logo.jpg'
import hati_logo from '../../assets/hati_logo.png'
import pony_logo from '../../assets/pony_logo.jpg'


function PartnerCard ({ partner }) {
    return (
        <div className='px-20 py-5 bg-slate-400 flex justify-center items-center'>
            <img src={partner.img} alt={partner.name} className='w-15'/>
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
        <div className='container w-sm mx-auto'>
            <h2>合作伙伴</h2>
            <div className='flex space-x-4 justify-around'>
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
