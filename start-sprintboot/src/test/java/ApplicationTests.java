import com.alibaba.fastjson.JSON;
import com.dong.springcloud.BootMain;
import com.dong.springcloud.config.CarInfo;
import com.dong.springcloud.service.impl.AsyncTaskService;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/9/3
 */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BootMain.class})
public class ApplicationTests {


    @Autowired
    private AsyncTaskService asyncService;
    @Autowired
    private CarInfo carInfo;

    @Test
    public void contextLoads() throws Exception {
//        asyncService.one();
//        asyncService.two();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i=0;i<100;i++){
            countDownLatch.countDown();
            log.info("-------,{}",i);
            String s = format.format(new Date())+"--->"+i;
            asyncService.three(s);
        }
        countDownLatch.await();
        log.info("---end--------");

    }

    @Test
    public void testProperty(){
        log.info("----carInfo-------,{}", JSON.toJSONString(carInfo));
    }

}
