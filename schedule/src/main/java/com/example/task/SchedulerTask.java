package com.example.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: Yinpeng.Lin
 * @desc: 定时任务
 * @date: Created in 2018/8/30 16:54
 */
@Component
public class SchedulerTask {
    private int count = 0;

    @Scheduled(cron = "*/6 * * * * ?")
    public void task1() {
        System.out.println("this is scheduler task running " + (count++));
    }

    @Scheduled(cron = "*/10 * * * * ?")
    public void task2() {
        System.out.println("this is scheduler task2 running " + new Date());
    }

}
