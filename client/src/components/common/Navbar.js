import React from 'react'
import { Link } from 'react-router-dom'

export default function Navbar() {
    return (
        <div className='navbar'>
            <div className='navbar_logo'>
                <svg class="icon" aria-hidden="true"> <use xlinkHref="#icon-React"></use> </svg>
            </div>

            <div className='navbar_links'>
                <ul>
                    <li> <Link to='/'>首页</Link> </li>
                    <li><Link to='/posts'>社群 </Link> </li>
                    <li><Link to='https://github.com/cherrieszzz/hi-box'><svg class="icon-nav-link" aria-hidden="true"> <use xlinkHref="#icon-github-fill"></use> </svg></Link> </li>
                </ul>
            </div>
        </div>
    )
}
