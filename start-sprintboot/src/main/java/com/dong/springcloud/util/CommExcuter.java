package com.dong.springcloud.util;

import com.dong.springcloud.entity.LogInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author dongjunpeng
 * @Description  重试工具类
 * @date 2021/7/30
 */
@Slf4j
public class CommExcuter {


    public static <T> T excuteRecodeLog(LogInfo logInfo,Supplier<T>supplier,@NotNull Supplier<T> errorHandler){
        return excuter(log->log==null,logInfo,supplier,1,0,errorHandler);
    }


    /**
     *
     * @param contidion 重试的条件
     * @param p 重试的参数
     * @param supplier 执行逻辑
     * @param tryNum  重试次数
     * @param interval 重试时间间隔
     * @param errorHandler 异常处理
     * @param <T>
     * @param <P>
     * @return
     */
    public static <T,P> T excuter(@NotNull Predicate<P> contidion, P p, @NotNull Supplier<T> supplier,Integer tryNum,Integer interval,@NotNull Supplier<T> errorHandler){

        if(tryNum==null||tryNum<=0){
            tryNum = 1;
        }
        if(interval!=null&&interval<=0){
            interval = 1000;//1秒
        }
        Throwable exp = null;
        for(int i=tryNum;i>0;i--){
            try {
//                if(contidion.test(p)){}
               return supplier.get();
            }catch (Throwable e){
                log.error("------message,{}-----exception,{}-----",e.getMessage(),e);
                exp = e;
            }
            Optional.ofNullable(interval).ifPresent(stime->{
                try {
                    TimeUnit.SECONDS.sleep(stime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    log.error("------message,{}-----exception,{}-----",e.getMessage(),e);
                    Thread.currentThread().interrupt();
                }

            });
        }

        Optional.ofNullable(exp).ifPresent(throwable -> log.error(throwable.getMessage(), throwable));
        return null == errorHandler ? null : errorHandler.get();
    }

}
