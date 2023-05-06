import React from 'react'
import { useParams } from 'react-router-dom'
import { useState, useEffect} from 'react'
import posts from '../data/posts'

export default function PostDetail({id}) {
    const [post, setPost] = useState(null)

    useEffect(() => {
        const getPost = posts.find((post) => post.id === id);
        console.log(getPost);
        setPost(getPost);
    }, [id])

    return (
      <div>
        <h2>Post Detail</h2>
        {post && <div>{post.body} </div>}
      </div>
     )
}
