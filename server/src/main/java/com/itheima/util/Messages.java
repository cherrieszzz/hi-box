package com.itheima.util;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * Messages
 *
 * @author WangFK
 * @version 1.0
 * @since 2023/5/3 20:31
 */
public class Messages {
    public class Role{
        // 身份标识
        final static public String Role_User="ROLE_USER";
        final static public String Role_Business="ROLE_BUSINESS";
        final static public String Role_Admin="ROLE_ADMIN";
        final static public String Role_Super_Admin="ROLE_SUPER_ADMIN";
    }
    public class Email{
        // 主题
        final static public String subject="hi-box官方验证码";
        // 前缀内容+code+data+后缀
        final static public String contendFix="<h1>亲爱的用户：您好！</h1>" +
                 "    <p>您收到这封电子邮件是因为您 (也可能是某人冒充您的名义) 注册 hi-box 账号。假如这不是您本人所申请, 请不用理会这封电子邮件, 但是如果您持续收到这类的信件骚扰, 请您尽快联络管理员。</p>" +
                "   <p>请使用以下验证码完成后续注册账号流程</p><h2><b>"  ;

        final static public String getContendEnd="</b></h2>" +"  <p>注意：请您收到邮件的五分钟内（<b>";
        final static public String getContendEnd1="</b>）前使用，否则验证码将会失效。</p>";


    }
}
