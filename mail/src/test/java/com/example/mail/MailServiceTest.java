package com.example.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.IOException;

/**
 * @author: Yinpeng.Lin
 * @desc:
 * @date: Created in 2018/8/30 17:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;
    @Autowired
    private SpringTemplateEngine templateEngine;


    @Test
    public void sendSimpleMail() throws Exception {
        mailService.sendSimpleMail("linyinpeng1989@126.com", "test simple email", "hello, this is a simple mail");
    }

    @Test
    public void testHtmlMail() throws Exception {
        String content = "<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("linyinpeng1989@126.com", "test simple mail", content);
    }

    @Test
    public void sendAttachmentsMail() throws IOException {
        // 系统资源路径
        // String filePath="d:\\test.jpg";
        // Resource resource = new FileSystemResource(filePath);

        // 类资源路径
        Resource resource = new ClassPathResource("test.jpg");
        mailService.sendAttachmentsMail("linyinpeng1989@126.com", "主题：带附件的邮件", "有附件，请查收！", resource);
    }

    @Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        // 系统资源路径
        // String filePath="d:\\test.jpg";
        // Resource resource = new FileSystemResource(filePath);

        // 类资源路径
        Resource resource = new ClassPathResource("test.jpg");
        mailService.sendInlineResourceMail("linyinpeng1989@126.com", "主题：这是有图片的邮件", content, resource, rscId);
    }

    @Test
    public void sendTemplateMail() {
        // 使用Thymeleaf模板创建邮件正文，模板文件为emailTemplate.html
        Context context = new Context();
        context.setVariable("hId", "125336131920301000");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("linyinpeng1989@126.com","主题：这是模板邮件",emailContent);
    }
}