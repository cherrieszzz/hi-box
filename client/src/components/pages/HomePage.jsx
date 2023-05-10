import React from 'react'
import CommonLayout from '../layouts/CommonLayout'
import haut_logo from '../../assets/haut_logo.png'
import zzuli_logo from '../../assets/zzuli_logo.jpg'
import hati_logo from '../../assets/hati_logo.png'
import pony_logo from '../../assets/pony_logo.jpg'

function Screen() {
  return (
    <div className='flex flex-col items-center space-y-3'>
      <h1 className='flex flex-col items-center'>
        <span className='text-7xl font-black bg-clip-text text-transparent bg-gradient-to-r from-green-400 to-blue-500'>Hi Box</span>
        <br />
        <p className=' text-7xl font-black'>你的私人健康管理专家</p>
      </h1>
      <p className='text-2xl text-gray-600 mt-2'>交互式健康交流社群</p>

      <div className='pt-3 space-x-10 mt-6'>
        <a href='/login' className='border-2 px-5 bg-green-500 py-2 rounded-lg ring-green-2 text-white hover:bg-green-300'>登陆</a>
      </div>
    </div>
  )
}

function Paltform() {
  return (
    <div className='flex justify-around items-center'>
      <div className=''>
        <div className="mockup-phone">
          <div className="camera"></div>
          <div className="display">
          <div className="artboard artboard-demo phone-1">
          <span className='text-4xl font-black bg-clip-text text-transparent bg-gradient-to-r from-green-400 to-blue-500'>Hi Box</span>
          </div>
          </div>
        </div>
      </div>

      <div className="divider divider-horizontal">OR</div>
      <div className="mockup-window border bg-base-300 min-w-[30rem]">
        <div className="flex justify-center px-4 py-16 bg-base-200">
        <span className='text-4xl font-black bg-clip-text text-transparent bg-gradient-to-r from-green-400 to-blue-500'>Hi Box</span>
        </div>
      </div>
    </div>
  )
}

function Partner() {

  function PartnerCard({ partner }) {
    return (
      <div className='w-full h-full py-3 flex justify-center items-center bg-gray-200 '>
        <img src={partner.img} alt={partner.name} className='max-h-[5rem] max-w-[12rem]' />
      </div>
    )
  }

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


function SectionPlat() {
  return (
    <div className='flex max-w-[80rem] mx-auto my-[10rem] space-x-5 justify-around flex-wrap'>
      <div className='max-w-[20rem] flex flex-col items-center space-y-[2rem]'>
        <svg aria-hidden="true" className='w-[18rem]'> <use xlinkHref="#icon-shequhuodong"></use> </svg>
        <h2 className='font-black text-2xl'>社区交流</h2>
        <p className='text-gray-600'>
          欢迎加入我们的社群！无论你是想找到新的灵感，还是想结交更多的朋友，我们都为你提供了一个舒适的环境。快来加入我们，开启一段全新的旅程吧！
        </p>
      </div>
      <div className='max-w-[20rem] flex flex-col items-center space-y-[2rem]'>
        <svg aria-hidden="true" className='w-[18rem]'> <use xlinkHref="#icon-dingzhi"></use> </svg>
        <h2 className='font-black text-2xl'>
          私人定制
        </h2>
        <p className='text-gray-600'>
          我们提供专业的私人订制服务，满足你的个性化需求。我们的团队将会与你紧密合作，确保你得到最满意的结果。快来尝试吧！
        </p>
      </div>
      <div className='max-w-[20rem] flex flex-col items-center space-y-[2rem]'>
        <svg aria-hidden="true" className='w-[18rem]'> <use xlinkHref="#icon-jiaoyu"></use> </svg>
        <h2 className='font-black text-2xl'>
          科普专栏
        </h2>
        <p className='text-gray-600'>
          科普，从现在开始。我们的专栏涵盖了各种各样的科学知识，从生态环保到新技术，从基础知识到前沿研究。
        </p>
      </div>
    </div>
  )
}

export default function Home() {
  return (
    <CommonLayout>
      <Screen />
      <SectionPlat />
      <Paltform />
      <Partner />
    </CommonLayout>
  )
}
