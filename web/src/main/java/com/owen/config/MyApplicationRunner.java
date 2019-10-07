package com.owen.config;

import com.owen.wxcontroller.LoginController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2018-05-15
 * \* Time: 22:14
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

@Component
@Order(value=1)
public class MyApplicationRunner implements ApplicationRunner {
    //日志
    private static final Logger logger = LoggerFactory.getLogger(MyApplicationRunner.class);
    @Override
    public void run(ApplicationArguments args)  {
        logger.info("==服务启动后，初始化数据操作==");
        new LoginController().entrance_token();
    }
}