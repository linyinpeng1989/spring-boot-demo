package com.example.demo.common.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by linyp on 2017/8/9.
 */
@Component
public class ScheduleTask {
    private int count = 0;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = "*/6 * * * * ?")
    public void process() {
        System.out.println("this is scheduler task running " + (count++));
    }

    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}
