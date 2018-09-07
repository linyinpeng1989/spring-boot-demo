package com.example.common.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @author: Yinpeng.Lin
 * @desc:
 * @date: Created in 2018/9/6 16:46
 */
@Configuration
public class ThreadPoolConfig {

    @Bean(value = "myCachedThreadPool")
    public ExecutorService buildCachedThreadPool() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("cachedThreadPool-%d").build();
        return Executors.newCachedThreadPool(threadFactory);
    }

    @Bean(value = "myFixedThreadPool")
    public ExecutorService buildFixedThreadPool() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("fixedThreadPool-%d").build();
        return Executors.newFixedThreadPool(10, threadFactory);
    }

    @Bean(value = "myScheduledThreadPool")
    public ExecutorService buildScheduledThreadPool() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("scheduledThreadPool-%d").build();
        return Executors.newScheduledThreadPool(4, threadFactory);
    }

    @Bean(value = "mySingleThreadExecutor")
    public ExecutorService buildSingleThreadExecutor() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("singleThreadExecutor-%d").build();
        return Executors.newSingleThreadExecutor(threadFactory);
    }

    @Bean(value = "mySingleThreadScheduledExecutor")
    public ExecutorService buildSingleThreadScheduledExecutor() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("singleThreadScheduledExecutor-%d").build();
        if(threadFactory != null) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~");
        }
        return Executors.newSingleThreadScheduledExecutor(threadFactory);
    }

    @Bean(value = "myWorkStealingPool")
    public ExecutorService buildWorkStealingPool() {
        return Executors.newWorkStealingPool(4);
    }

    @Bean(value = "myConsumerThreadPool")
    public ExecutorService buildConsumerThreadPool() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("consumer-queue-thread-%d").build();
        return new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5), threadFactory, new ThreadPoolExecutor.AbortPolicy());
    }

}
