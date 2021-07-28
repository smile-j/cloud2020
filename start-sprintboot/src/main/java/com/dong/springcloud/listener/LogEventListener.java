package com.dong.springcloud.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author dongjunpeng
 * @Description  日志异步-------记录
 * @date 2021/7/16
 */
@Component
@Slf4j
public class LogEventListener {



    @Async
//    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @EventListener
    public void writeLog(String logStr){

        log.info("---日志记录---[{}]",logStr);

    }

}
