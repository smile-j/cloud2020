package com.dong.springcloud.comm.rep;

import com.dong.springcloud.comm.enums.ServiceStatus;
import com.dong.springcloud.entity.UserEntity;
import lombok.Data;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/21
 */
@Data
public class TestReq {

    private String name;
    private UserEntity user;
    private ServiceStatus serviceStatus;

}
