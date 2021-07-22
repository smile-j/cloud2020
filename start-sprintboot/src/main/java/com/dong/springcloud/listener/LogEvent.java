package com.dong.springcloud.listener;

import org.springframework.context.ApplicationEvent;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/16
 */
public class LogEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param msgStr the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public LogEvent(String msgStr) {
        super(msgStr);
    }
}
