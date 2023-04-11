import React from 'react'

export default function PostCard({ post }) {
  return (
    <div className='postcard'>
        <h3>{post.title}</h3>
    </div>
  )
}
