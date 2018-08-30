package com.example.mail;

import org.springframework.core.io.Resource;

/**
 * @author: Yinpeng.Lin
 * @desc: 邮件服务
 * @date: Created in 2018/8/30 16:54
 */
public interface MailService {
    /**
     * 发送简单邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendSimpleMail(String to, String subject, String content);

    /**
     * 发送带HTML的邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendHtmlMail(String to, String subject, String content);

    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param resource
     */
    void sendAttachmentsMail(String to, String subject, String content, Resource resource);

    /**
     * 发送带静态资源的邮件
     * @param to
     * @param subject
     * @param content
     * @param resource
     * @param rscId
     */
    void sendInlineResourceMail(String to, String subject, String content, Resource resource, String rscId);
}
