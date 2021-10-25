package com.dong.springcloud.util;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/9/3
 */
public class TestRunnable implements Runnable{

    private String bizMessage;
    public TestRunnable(String bizMessage){
        this.bizMessage = bizMessage;
    }
    @Override
    public void run() {
        System.out.println(bizMessage+"--SUCCESS!");
    }

    public String getBizMessage() {
        return bizMessage;
    }
}
