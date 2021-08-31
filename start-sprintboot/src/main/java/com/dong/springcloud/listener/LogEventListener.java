package com.dong.springcloud.listener;

import com.alibaba.fastjson.JSON;
import com.dong.springcloud.entity.LogInfo;
import com.dong.springcloud.util.CommExcuter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

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
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date current = new Date();
        LogInfo logInfo = LogInfo.builder().info(logStr).curTime(new Date()).build();
        String uuid  = CommExcuter.excuteRecodeLog(logInfo,()->{
            log.info("当前时间："+format.format(current));
            log.info("--success-excutor-,{}", JSON.toJSONString(logInfo));
            return UUID.randomUUID().toString().replace("-", "");
        }, ()->{//失败处理的函数
            log.info("当前时间："+format.format(current));
            log.info("--error-excutor-,{}", JSON.toJSONString(logInfo));
            return UUID.randomUUID().toString().replace("-", "");
            }
        );

    }

}
