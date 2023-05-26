package com.itheima.util;

import com.itheima.exception.BusinessException;

/**
 * 邮箱工具类
 *
 * @author WangFK
 * @version 1.0
 * @since 2023/5/11 14:52
 */
public class MailUtil {
    /**
     * 发送普通文本邮件
     * @param email    接受人邮箱
     * @param subject  主题
     * @param content  内容
     * @return
     */
    public static void sendText(String email,String subject,String content){
        try {
            cn.hutool.extra.mail.MailUtil.send(email,subject,content,false);
        } catch (Exception e) {
            throw new BusinessException("邮箱发送失败");
        }
    }
    /**
     * 发送html邮件
     * @param email    接受人邮箱
     * @param subject  主题
     * @param content  内容
     * @return
     */
    public static void sendHtml(String email,String subject,String content){
        try {
            cn.hutool.extra.mail.MailUtil.send(email,subject,content,true);
        } catch (Exception e) {
            throw new BusinessException("邮箱发送失败");
        }
    }


}
