import React from 'react'
import { Link } from 'react-router-dom'

export default function PostCard({ post }) {
  return (
    <div className='postcard'>
        <h3><Link to={'/posts/' + post.id}>{post.title}</Link> </h3>
    </div>
  )
}
