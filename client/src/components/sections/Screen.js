import React from 'react'
import styles from './Screen.module.css'

export default function Screen() {
  return (
    <div className={styles.screen}>
      <h1>
        <span className={styles.yellow_green_title}>Hi Box</span>
        <br />
        你的私人健康管理专家</h1>
      <p className={styles.description}>交互式健康交流社群</p>
      <div className={styles.screen_btn_group}>
        <a className={styles.screen_btn}>注册</a>
        <a className={styles.screen_btn} href='/login'>登陆</a>
      </div>
    </div>
  )
}
