import React from 'react'
import PostList from '../PostList'
import CommonLayout from '../layouts/CommonLayout'
import posts from '../../data/posts'

export default function SocialPage() {
  return (
    <CommonLayout>
        <PostList posts={posts} />
    </CommonLayout>
  )
}
