package com.dong.springcloud.comm.constant;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/30
 */
public class RedisKey {

    public final static String comm_lock_key="cloud202:common:key_";
    public final static String order_lock_key="cloud202:order:order_id_key_";

    public static String getcommKey(String key){
        return comm_lock_key+key;
    }

}
