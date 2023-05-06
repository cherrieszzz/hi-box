import React from 'react'
import PostList from '../PostList'
import CommonLayout from '../layouts/CommonLayout'
import Screen from '../sections/Screen'
import Partner from '../sections/Partner'

export default function Home() {
  return (
    <CommonLayout>
        <Screen />
        <Partner />
    </CommonLayout>
  )
}
