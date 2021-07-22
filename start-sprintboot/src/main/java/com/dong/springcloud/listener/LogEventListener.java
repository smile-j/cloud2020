package com.dong.springcloud.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/16
 */
@Component
@Slf4j
public class LogEventListener {


    public void writeLog(String logStr){

        log.info("---日志记录---[{}]",logStr);

    }

}
