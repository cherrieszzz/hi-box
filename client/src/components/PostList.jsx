import React from 'react'
import posts from '../data/posts'
import PostCard from './PostCard'

export default function PostList({posts}) {
  return (
    <div>
        <h2>Post List</h2>
        {
            posts.map((post) => (
                <PostCard key={post.id} post={post} />
            ))
        }
    </div>
  )
}
