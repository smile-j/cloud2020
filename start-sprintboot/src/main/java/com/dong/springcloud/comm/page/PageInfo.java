package com.dong.springcloud.comm.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/7
 */
@Data
@ApiModel("分页信息")
public class PageInfo {

    @ApiModelProperty("页码")
    private int pageNum = 1;

    @ApiModelProperty("每页条数")
    private int pageSize = 10;

    @ApiModelProperty("分页方向")
    private Direction direction;

    private String lastIndex;

    public enum Direction {
        /** 上一页 */
        PREV,
        /** 下一页 */
        NEXT;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex(String lastIndex) {
        this.lastIndex = lastIndex;
    }
}
