package com.dong.springcloud.service;

import com.dong.springcloud.comm.IResultCode;
import com.dong.springcloud.comm.rep.PageResponse;
import com.dong.springcloud.comm.rep.Response;
import com.dong.springcloud.entity.UserEntity;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/8
 */
public abstract class  BaseApiService {

    protected <T> Response<T> ok(T data) {
        return Response.ok(data);
    }


   /* protected <T> Response<T> fail(IResultCode resultCode) {
        return Response.fail(resultCode);
    }

    protected <T> Response<T> fail(String errorMessage) {
        return Response.fail(errorMessage);
    }

    protected <T> PageResponse<T> page(T data) {
        return Response.page(data);
    }

    protected <T> PageResponse<T> page(T data, Integer totalCount) {
        return Response.page(data, totalCount);
    }

    protected <T> PageResponse<T> pageFail(IResultCode resultCode) {
        return PageResponse.fail(resultCode);
    }

    protected <T> PageResponse<T> pageFail(String errorMessage) {
        return PageResponse.fail(errorMessage);
    }*/

}
