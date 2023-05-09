import React from 'react'
import PostList from '../PostList'
import CommonLayout from '../layouts/CommonLayout'
import Screen from '../sections/Screen'
import Partner from '../sections/Partner'
import SectionPlat from '../sections/SectionPlat'

export default function Home() {
  return (
    <CommonLayout>
        <Screen />
        <SectionPlat />
        <Partner />
    </CommonLayout>
  )
}
