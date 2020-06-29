package priv.yangkuncheng.log;

import org.junit.jupiter.api.Test;
import org.slf4j.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
class LogApplicationTests {
    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    void contextLoads() {
        /*
        日志的级别：
        由低到高 trace<debug<info<warn<error
        可以调整输出的日志级别，日志就只会在这个级别以后的高级别生效
         */

        logger.trace("这是trace日志...");
        logger.debug("这是dug日志");
        //springboot默认给我们使用的是info级别 没有指定级别就用springboot默认规划的级别
        logger.info("这是info日志");
        logger.warn("这是warn日志");
        logger.error("这是error日志");
    }
}
