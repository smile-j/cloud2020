import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dong.springcloud.BootMain;
import com.dong.springcloud.entity.DeptEntity;
import com.dong.springcloud.entity.LogEntity;
import com.dong.springcloud.service.impl.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/10/29
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BootMain.class})
public class TestTransaction {
    @Autowired
    private TransactionalService transactionalService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private TransactionalService2 transactionalService2;
    @Autowired
    private TransactionService transactionService;

    @Test
    public void test3(){
       transactionService.testInsert();
    }

    @Test
    public void test2(){
        deptService.insert(DeptEntity.builder().deptNo("01").deptName("部门01").remarks("备注01").build());
        deptService.insert(DeptEntity.builder().deptNo("02").deptName("部门02").remarks("备注02").build());
        deptService.insert(DeptEntity.builder().deptNo("03").deptName("部门03").remarks("备注03").build());
        log.info("=====,{}",JSONObject.toJSONString(deptService.findById(1)));
        log.info("=====,{}",JSONObject.toJSONString(deptService.findList(DeptEntity.builder().remarks("备注01").build())));
    }

    @Test
    public void test1(){
        LogEntity build = LogEntity.builder().content("aaa-aa").createTime(new Date()).type(1).build();
        transactionalService.insert(build);
        log.info("------,{}",JSONObject.toJSONString(build));
        transactionalService.insert(LogEntity.builder().content("bbb-bb").createTime(new Date()).type(2).build());
        transactionalService.insert(LogEntity.builder().content("ccc-cc").createTime(new Date()).type(3).build());

        LogEntity logEntity = transactionalService.queryById(3);
        log.info("==1==,{}", JSONObject.toJSONString(logEntity));
        List<LogEntity> logEntities = transactionalService.queryList(LogEntity.builder().type(1).build());
        log.info("==2==,{}", JSONObject.toJSONString(logEntities));

    }


}
