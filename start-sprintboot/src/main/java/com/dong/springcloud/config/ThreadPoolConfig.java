package com.dong.springcloud.config;

import com.dong.springcloud.util.TestRunnable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/26
 */
@Configuration
@Slf4j
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

    @Bean("multiGuaranteeExecutor")
    public Executor mutiGuaranteeExecutor(){
        ThreadPoolTaskExecutor multiGuaranteeExecutor = new ThreadPoolTaskExecutor();
        multiGuaranteeExecutor.setCorePoolSize(10);
        multiGuaranteeExecutor.setMaxPoolSize(20);
        multiGuaranteeExecutor.setQueueCapacity(200);
        multiGuaranteeExecutor.setKeepAliveSeconds(30);
        // 设置线程名称前缀，当程序出现性能问题时，使用jstack命令、JvisualVM、JProfile工具根据线程名称可以快速定位代码问题。
        multiGuaranteeExecutor.setThreadNamePrefix("multi-guarantee-thread--");
        // 使用自定义拒绝策略，保证重要数据不丢失
        multiGuaranteeExecutor.setRejectedExecutionHandler(new CustomRejectedExecutionHandler());
        return multiGuaranteeExecutor;
    }

    @Bean("simpleExecutor")
    public Executor simpleExecutor() {
        ThreadPoolTaskExecutor simpleExecutor = new ThreadPoolTaskExecutor();
        simpleExecutor.setCorePoolSize(3);
        simpleExecutor.setMaxPoolSize(5);
        simpleExecutor.setQueueCapacity(10);
        simpleExecutor.setKeepAliveSeconds(30);
        simpleExecutor.setThreadNamePrefix("simple-thread--");
        simpleExecutor.setRejectedExecutionHandler(new CustomRejectedExecutionHandler());
        return simpleExecutor;
    }

    /**
     * Customize thread factory
     */
    private class CustomThreadFactory implements ThreadFactory {
        private AtomicInteger count = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            String threadName = "multi-guarantee-thread-" + count.getAndIncrement();
            t.setName(threadName);
            return t;
        }
    }


    /**
     * Customize rejected handler
     */
    private class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                //获取业务线程上下文 信息
                if(r instanceof TestRunnable){
                    TestRunnable runnable = (TestRunnable) r;
                    log.info("-----上下文信息------,{}",runnable.getBizMessage());
                }
                // 一直尝试往队列中添加任务
                // 此处通过打印日志、发MQ等操作保证数据不丢失；减少线程池的工作压力。
                executor.getQueue().put(r);
                log.info("multi-guarantee thread executed failure");
            } catch (InterruptedException e) {
                log.error("Exception in putting thread queue again, ", e);
            }

        }
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
