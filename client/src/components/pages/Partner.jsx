import React from 'react'
import CommonLayout from '../layouts/CommonLayout'
import haut_logo from '../../assets/haut_logo.png'
import zzuli_logo from '../../assets/zzuli_logo.jpg'
import hati_logo from '../../assets/hati_logo.png'
import pony_logo from '../../assets/pony_logo.jpg'
import huahe_logo from '../../assets/huahe_logo.jpg'
import wbgj_logo from '../../assets/wbgj_logo.png'
import wbwl_logo from '../../assets/wbwl_logo.png'

function PartnerLayer() {

  function PartnerCard({ partner }) {
    return (
      <div className='w-full h-full py-3 flex justify-center items-center bg-gray-200 '>
        <img src={partner.img} alt={partner.name} className='max-h-[5rem] max-w-[12rem]' />
      </div>
    )
  }
//1.高校：河南工业大学、郑州轻工业大学、河南牧业经济学院、河南应用技术职业学院
//2.企业：谱尼测试、万邦物流、河南万邦国际农产品物流股份有限公司
  const partnerSchoolData = [
    {
      name: 'haut',
      img: haut_logo,
    },
    {
      name: 'zzuli',
      img: zzuli_logo,
    },
    {
      name: 'huahe',
      img: huahe_logo,
    },
    {
      name: 'hati',
      img: hati_logo
    }
  ]

  const partnerMerchantData = [
    {
      name: 'pony',
      img: pony_logo,
    },
    {
      name: 'wbgj',
      img: wbgj_logo,
    },
    {
      name: 'wbwl',
      img: wbwl_logo,
    }    
  ]

  return (
    <div className='container w-sm mx-auto my-[15rem]'>
      <div className='max-w-[50rem] mx-auto'>
        <div className='w-full flex justify-center'>
        <h2 className='font-black text-lg'>合作伙伴</h2>
        </div>
  
        <h3>合作高校</h3>
        <div className='grid grid-cols-3 gap-1 grid-flow-row max-w-[50rem] mx-auto'>
          {
            partnerSchoolData.map((partner) => {
              return (
                <p>
                  <PartnerCard partner={partner} />
                </p>
              )
            })
          }
        </div>
        <h3>合作企业</h3>
        <div className='grid grid-cols-3 gap-1 grid-flow-row max-w-[50rem] mx-auto'>
          {
            partnerMerchantData.map((partner) => {
              return (
                <p>
                  <PartnerCard partner={partner} />
                </p>
              )
            })
          }
        </div>
      </div>
    </div>
  )
}

const Partner = () => {
  return (
    <CommonLayout>
    <div>
      <PartnerLayer />
    </div>
    </CommonLayout>
  )
}

export default Partner