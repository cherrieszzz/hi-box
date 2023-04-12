import React from 'react'
import PostList from '../PostList'
import CommonLayout from '../layouts/CommonLayout'
import Screen from '../context/Screen'
import Partner from '../context/Partner'
export default function Home() {
  return (
    <CommonLayout>
        <Screen />
        <Partner />
    </CommonLayout>
  )
}
