package com.owen.wxcontroller;

import com.owen.wxutils.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.PrintWriter;

@Controller
@RequestMapping("SSM-WeChat")
public class LoginController {
    //打印日志信息
    private static Logger log = LoggerFactory.getLogger(LoginController.class);
    /**
     * 微信接入
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @param out
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void getWXInfo(@Param("signature") String signature,
                          @Param("timestamp") String timestamp,
                          @Param("nonce") String nonce,
                          @Param("echostr") String echostr,
                          PrintWriter out
    ) {
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (Validation.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
        } else {
            System.out.println("不是微信服务器发来的请求!");
        }
        out.flush();
        out.close();
    }


}

