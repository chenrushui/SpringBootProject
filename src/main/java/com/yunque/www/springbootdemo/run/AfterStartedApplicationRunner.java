package com.yunque.www.springbootdemo.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * 在容器启动的时候执行一些内容。比如读取配置文件，数据库连接之类的。
 * 容器启动完成的时候。
 *
 */
@Component
@Order(1)
public class AfterStartedApplicationRunner implements ApplicationRunner {

    public Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info(args.toString());
        logger.info("测试启动完成监听");
    }
}
