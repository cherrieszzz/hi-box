import React, { Component } from 'react';

export default function SectionPlat() {
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