package com.dong.springcloud.comm.req;

import com.dong.springcloud.comm.page.PageInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/8
 */
@Data
public class PageRequest<T> extends Request<T>{

    @ApiModelProperty("分页信息")
    private PageInfo pageInfo;

}
