package com.dong.springcloud.dao;

import com.dong.springcloud.entity.LogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/10/29
 */
@Mapper
public interface LogDao {

    void insertOne(LogEntity logEntity);
    LogEntity selectById(@Param("id") Integer id );
//    List<Map<String, Object>> querySql(@Param("sql") String sql);
    List<LogEntity> selectList(LogEntity logEntity);

}
