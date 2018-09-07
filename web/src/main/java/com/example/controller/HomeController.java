package com.example.controller;

import com.example.common.property.PropertiesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author: Yinpeng.Lin
 * @desc:
 * @date: Created in 2018/8/23 12:27
 */
@RestController
public class HomeController {
    @Autowired
    private PropertiesBean propertiesBean;
    @Resource(name = "myCachedThreadPool")
    private ExecutorService executorService;

    /**
     * 获取自定义属性
     * @return
     */
    @GetMapping("/property")
    public SimpleProperty property() {
        return new SimpleProperty(propertiesBean.getTitle(), propertiesBean.getDescription());
    }

    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/user")
    public SimpleUser user() {
        return new SimpleUser(18, "小李子");
    }

    /**
     * 线程池测试
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @GetMapping("/threadPool")
    public SimpleUser threadPoolTest() throws ExecutionException, InterruptedException {
        Future<?> future1 = executorService.submit(() -> System.out.println("执行runnable任务，无返回值"));
        System.out.println(future1.get());

        Future<SimpleUser> future3 = executorService.submit(() -> new SimpleUser(20, "小贵子"));
        return future3.get();
    }

    public static class SimpleUser {
        private Integer age;
        private String name;

        public SimpleUser(Integer age, String name) {
            this.age = age;
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class SimpleProperty{
        private String title;
        private String desc;

        public SimpleProperty(String title, String desc) {
            this.title = title;
            this.desc = desc;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
