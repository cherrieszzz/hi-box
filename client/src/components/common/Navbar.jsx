import React from 'react'
import { Link } from 'react-router-dom'
import nav_logo from '../../assets/logo.png'

export default function Navbar() {
    return (
        <div className='flex justify-between items-center py-3 px-10 border-b-2 fixed top-0 w-full bg-gray-50 z-10'>
            <div className='flex items-center space-x-3'>
                <Link to={'/'} className='w-20 h-10'><img src={nav_logo} alt='logo' className='w-10 h-10' /></Link>
                <svg className='w-7 h-7' aria-hidden="true"> <use xlinkHref="#icon-ic_search24px"></use> </svg>
                <input type='text' className='w-full border-2 rounded-lg px-2 py-1 focus:outline-none focus:ring-2 focus:ring-green-500 focus:ring-opacity-50'></input>
            </div>

            <div className=''>
                <ul className='flex items-center'>
                    <li className='mx-2'> <Link to='/'>文档</Link> </li>
                    <li className='mx-2'> <Link to='/goods'>商城</Link> </li>
                    <li className='mx-2'> <Link to='/'>生态系统</Link> </li>
                    <li className='mx-2'> <Link to='/'>合作伙伴</Link> </li>
                    <li className='mx-2'> <Link to='/'>赞助</Link> </li>
                    <li className='mx-2'> <Link to='/'>关于</Link> </li>
                    <li className='mx-2'><Link to='https://discord.com/channels/1048112565600931880/1096061711229923439'>社群 </Link> </li>
                    <li className='mx-2'><Link to='https://github.com/cherrieszzz/hi-box'><svg aria-hidden="true" className='w-7 h-7'> <use xlinkHref="#icon-github-fill"></use> </svg></Link> </li>
                    <li className='mx-2'><Link to='https://github.com/cherrieszzz/hi-box'><svg aria-hidden="true" className='w-7 h-7'> <use xlinkHref="#icon-wechat"></use> </svg></Link> </li>
                    <li className='mx-2'><Link to='https://github.com/cherrieszzz/hi-box'><svg aria-hidden="true" className='w-7 h-7'> <use xlinkHref="#icon-qq"></use> </svg></Link> </li>
                    <li className='mx-2'><Link to='https://www.douyin.com/user/MS4wLjABAAAAYwDptOsZA2dit3yphA_HmaAXMSFgtZmn5-5ectIIuy6mGGRktPqvv4mEgRb6ODHh'><svg aria-hidden="true" className='w-7 h-7'> <use xlinkHref="#icon-tiktok"></use> </svg></Link> </li>
                    <li className='mx-2'><Link to='https://www.xiaohongshu.com/user/profile/5c561b89000000001802e3e7'><svg aria-hidden="true" className='w-7 h-7'> <use xlinkHref="#icon-jiaqiangban"></use> </svg></Link> </li>
                    <li className='mx-2'><Link to={'/me'}>me</Link> </li>
                </ul>
            </div>
        </div>
    )
}
