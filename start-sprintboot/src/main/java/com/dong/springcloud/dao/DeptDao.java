package com.dong.springcloud.dao;

import com.dong.springcloud.entity.DeptEntity;
import com.dong.springcloud.entity.LogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/10/29
 */
@Mapper
public interface DeptDao {

    void insertOne(DeptEntity deptEntity);
    DeptEntity selectById(@Param("id") Integer id );
//    List<Map<String, Object>> querySql(@Param("sql") String sql);
    List<DeptEntity> selectList(DeptEntity deptEntity);

}
