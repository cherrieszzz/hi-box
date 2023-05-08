import React from 'react'
import haut_logo from '../../assets/haut_logo.png'
import zzuli_logo from '../../assets/zzuli_logo.jpg'
import hati_logo from '../../assets/hati_logo.png'
import pony_logo from '../../assets/pony_logo.jpg'


function PartnerCard({ partner }) {
    return (
        <div className='w-full h-full py-3 flex justify-center items-center bg-gray-200 '>
            <img src={partner.img} alt={partner.name} className='max-h-[5rem] max-w-[12rem]' />
        </div>
    )
}

export default function Partner() {
    const partnerData = [
        {
            name: 'haut',
            img: haut_logo,
        },
        {
            name: 'zzuli',
            img: zzuli_logo,
        },
        {
            name: 'pony',
            img: pony_logo,
        },
        {
            name: 'hati',
            img: hati_logo
        }
    ]

    return (
        <div className='container w-sm mx-auto my-[15rem]'>
            <div className='max-w-[50rem] mx-auto'>
                <h2 className='font-black text-lg'>合作伙伴</h2>
                <div className='grid grid-cols-3 gap-1 grid-flow-row max-w-[50rem] mx-auto'>
                    {
                        partnerData.map((partner) => {
                            return (
                                <PartnerCard partner={partner} />
                            )
                        })
                    }
                </div>
            </div>

        </div>
    )
}
