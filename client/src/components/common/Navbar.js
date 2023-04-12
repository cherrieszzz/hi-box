import React from 'react'
import { Link } from 'react-router-dom'
import nav_logo from '../../assets/logo.png'

export default function Navbar() {
    return (
        <div className='navbar'>
            <div className='navbar-logo'>
                {/* <svg class="icon" aria-hidden="true"> <use xlinkHref="#icon-React"></use> </svg> */}
                <img src={nav_logo} alt='logo' />
                <svg class="icon-search" aria-hidden="true"> <use xlinkHref="#icon-ic_search24px"></use> </svg>
                <input type='text'></input>
            </div>

            <div className='navbar-links'>
                <ul>
                    <li> <Link to='/'>文档</Link> </li>
                    <li> <Link to='/'>商城</Link> </li>
                    <li> <Link to='/'>生态系统</Link> </li>
                    <li> <Link to='/'>合作伙伴</Link> </li>
                    <li> <Link to='/'>赞助</Link> </li>
                    <li> <Link to='/'>关于</Link> </li>
                    <li><Link to='/social'>社群 </Link> </li>
                    <li><Link to='https://github.com/cherrieszzz/hi-box'><svg class="icon-nav-link" aria-hidden="true"> <use xlinkHref="#icon-github-fill"></use> </svg></Link> </li>
                    <li><Link to='https://github.com/cherrieszzz/hi-box'><svg class="icon-nav-link" aria-hidden="true"> <use xlinkHref="#icon-wechat"></use> </svg></Link> </li>
                    <li><Link to='https://github.com/cherrieszzz/hi-box'><svg class="icon-nav-link" aria-hidden="true"> <use xlinkHref="#icon-qq"></use> </svg></Link> </li>
                </ul>
            </div>
        </div>
    )
}
