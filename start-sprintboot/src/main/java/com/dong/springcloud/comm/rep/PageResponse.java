package com.dong.springcloud.comm.rep;

import com.dong.springcloud.comm.IResultCode;
import com.dong.springcloud.comm.page.PageInfo;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/7
 */
@Data
@ToString(callSuper = true)
public class PageResponse <D> extends Response{

    private Long totalCount;
    private PageInfo pageInfo;

    public PageResponse() {
    }

    public PageResponse(D data, Long totalCount,IResultCode resultCode) {
        super(data,resultCode);
        this.totalCount = totalCount;
    }


}
