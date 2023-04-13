import React from 'react'
import { Link } from 'react-router-dom'
import nav_logo from '../../assets/logo.png'
import './Navbar.module.css'
import styles from './Navbar.module.css'

export default function Navbar() {
    return (
        <div className={styles.navbar}>
            <div className={styles.navbar_logo}>
                {/* <svg class="icon" aria-hidden="true"> <use xlinkHref="#icon-React"></use> </svg> */}
                <img src={nav_logo} alt='logo' />
                <svg class={styles.icon_search} aria-hidden="true"> <use xlinkHref="#icon-ic_search24px"></use> </svg>
                <input type='text'></input>
            </div>

            <div className={styles.navbar_links}>
                <ul>
                    <li> <Link to='/'>文档</Link> </li>
                    <li> <Link to='/'>商城</Link> </li>
                    <li> <Link to='/'>生态系统</Link> </li>
                    <li> <Link to='/'>合作伙伴</Link> </li>
                    <li> <Link to='/'>赞助</Link> </li>
                    <li> <Link to='/'>关于</Link> </li>
                    <li><Link to='/social'>社群 </Link> </li>
                    <li><Link to='https://github.com/cherrieszzz/hi-box'><svg class={styles.icon_nav_link} aria-hidden="true"> <use xlinkHref="#icon-github-fill"></use> </svg></Link> </li>
                    <li><Link to='https://github.com/cherrieszzz/hi-box'><svg class={styles.icon_nav_link} aria-hidden="true"> <use xlinkHref="#icon-wechat"></use> </svg></Link> </li>
                    <li><Link to='https://github.com/cherrieszzz/hi-box'><svg class={styles.icon_nav_link} aria-hidden="true"> <use xlinkHref="#icon-qq"></use> </svg></Link> </li>
                </ul>
            </div>
        </div>
    )
}
