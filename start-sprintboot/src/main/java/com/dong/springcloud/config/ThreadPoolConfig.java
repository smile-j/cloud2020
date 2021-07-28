package com.dong.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/26
 */
@Configuration
public class ThreadPoolConfig {

    @Bean("lazyTraceExecutor")
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //此方法返回可用处理器的虚拟机的最大数量; 不小于1
        int core = Runtime.getRuntime().availableProcessors();
        executor.setCorePoolSize(core);//设置核心线程数
        executor.setMaxPoolSize(core * 2 + 1);//设置最大线程数
        executor.setKeepAliveSeconds(3);//除核心线程外的线程存活时间
        executor.setQueueCapacity(40);//如果传入值大于0，底层队列使用的是LinkedBlockingQueue,否则默认使用SynchronousQueue
        executor.setThreadNamePrefix("my-executor-");//线程名称前缀
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());//设置拒绝策略
//        return new LazyTraceThreadPoolTaskExecutor(beanFactory, executor);
        executor.initialize();

        return executor;
    }

    public void test(){
        ThreadPoolExecutor poolExecutor  = new ThreadPoolExecutor(3,3
                ,100L,TimeUnit.SECONDS,new LinkedBlockingQueue<>(100));
        //线程池会提前创建并启动核心线程
        poolExecutor.prestartAllCoreThreads();
        poolExecutor.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
//        ExecutorService executorService = Executors.newFixedThreadPool(3);

    }

}
