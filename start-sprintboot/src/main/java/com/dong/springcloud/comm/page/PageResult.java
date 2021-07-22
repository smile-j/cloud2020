package com.dong.springcloud.comm.page;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/8
 */
@Data
public class PageResult<T> {

    private List<T> content = new ArrayList<T>();

    private long totalCount;

}
