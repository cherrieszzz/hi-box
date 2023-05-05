import React from 'react'
import { Link } from 'react-router-dom'
import nav_logo from '../../assets/logo.png'

export default function Navbar() {
    return (
        <div className='flex justify-between'>
            <div>
                {/* <svg class="icon" aria-hidden="true"> <use xlinkHref="#icon-React"></use> </svg> */}
                <img src={nav_logo} alt='logo' className='w-10 h-10' />
                <svg className='w-10' aria-hidden="true"> <use xlinkHref="#icon-ic_search24px"></use> </svg>
                <input type='text'></input>
            </div>

            <div className=''>
                <ul className='flex align-center'>
                    <li className='mx-2'> <Link to='/'>文档</Link> </li>
                    <li className='mx-2'> <Link to='/'>商城</Link> </li>
                    <li  className='mx-2'> <Link to='/'>生态系统</Link> </li>
                    <li  className='mx-2'> <Link to='/'>合作伙伴</Link> </li>
                    <li className='mx-2'> <Link to='/'>赞助</Link> </li>
                    <li className='mx-2'> <Link to='/'>关于</Link> </li>
                    <li className='mx-2'><Link to='/social'>社群 </Link> </li>
                    <li className='mx-2'><Link to='https://github.com/cherrieszzz/hi-box'><svg aria-hidden="true" className='w-10'> <use xlinkHref="#icon-github-fill"></use> </svg></Link> </li>
                    <li className='mx-2'><Link to='https://github.com/cherrieszzz/hi-box'><svg aria-hidden="true" className='w-10'> <use xlinkHref="#icon-wechat"></use> </svg></Link> </li>
                    <li className='mx-2'><Link to='https://github.com/cherrieszzz/hi-box'><svg aria-hidden="true" className='w-10'> <use xlinkHref="#icon-qq"></use> </svg></Link> </li>
                </ul>
            </div>
        </div>
    )
}
