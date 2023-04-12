import React from 'react'
import { useParams } from 'react-router-dom'
import PostDetail from '../PostDetail'
import CommonLayout from '../layouts/CommonLayout'

export default function PostPage() {
  const { id } = useParams()
  return (
    <CommonLayout>
        <PostDetail postId={id} />
    </CommonLayout>
  )
}
