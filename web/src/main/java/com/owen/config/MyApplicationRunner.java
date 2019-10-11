package com.owen.config;

import com.owen.MenuUtils.CreateMenu;
import com.owen.MenuUtils.PostMenu;
import com.owen.service.access_tokenservice.Access_TokenService;
import com.owen.wxcontroller.MenuController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


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
@EnableScheduling
@Order(value=1)
public class MyApplicationRunner implements ApplicationRunner {
    //日志
    private static final Logger logger = LoggerFactory.getLogger(MyApplicationRunner.class);
    @Override
    public void run(ApplicationArguments args)  {
        logger.info("==服务启动后，初始化数据操作==");
    }
}