package com.example.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: Yinpeng.Lin
 * @desc: 发送者
 * @date: Created in 2018/8/30 10:08
 */
@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    /************************************************* Direct交换器 ***************************************************/
    public void send() {
        String content = "hello " + new Date();
        System.out.println("Sender: " + content);
        this.rabbitTemplate.convertAndSend("helloQueue", content);
    }

    public void send(Integer index) {
        String content = "hello " + index + " " + new Date();
        System.out.println("Sender: " + content);
        this.rabbitTemplate.convertAndSend("helloQueue", content);
    }

    public void sendObject(User user) {
        System.out.println("Sender: " + user.toString());
        this.rabbitTemplate.convertAndSend("objectQueue", user.toString());
    }

    public static class User {
        private String name;
        private String sex;
        private String age;

        public User(String name, String sex, String age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }


    /************************************************* Topic交换器 ****************************************************/
    public void sendTopic1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", context);
    }

    public void sendTopic2() {
        String context = "hi, i am message 2";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.messageabc", context);
    }

    /************************************************* Fanout交换器 ***************************************************/
    public void sendFanout() {
        String context = "hi, i am fanout message";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange", "", context);
    }

}


