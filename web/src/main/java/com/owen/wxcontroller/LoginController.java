package com.owen.wxcontroller;


import com.owen.service.Message.MessageService;
import com.owen.wxutils.TokenThread;
import com.owen.wxutils.Validation;
import com.owen.wxutils.WxUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    @GetMapping("/")
    public void getWXInfo(@Param("signature") String signature,
                          @Param("timestamp") String timestamp,
                          @Param("nonce") String nonce,
                          @Param("echostr") String echostr,
                          PrintWriter out
    ) {
        if (Validation.checkSignature(signature,timestamp,nonce)){
            System.out.println("接入成功");
            out.print(echostr);
        }else {
            System.out.println("不是微信发来的请求");
        }
        out.flush();
        out.close();
    }
    /**
     * 启动线程获取token
     */
    public void entrance_token() {
        Logger log = LoggerFactory.getLogger(TokenThread.class);
        log.info("微信 api appid:{}", WxUtils.appID);
        log.info("微信 api appsecret:{}", WxUtils.appsecret);
        // 未配置appid和appsecret时给出提示
        if ("".equals(WxUtils.appID) || "".equals(WxUtils.appsecret)) {
            log.error("appid and appsecret配置错误，请仔细检查！");
        } else {
            // 启动定时获取access_token的线程
           new Thread(new TokenThread()).start();
        }
    }
    /**
     * 消息类回复需要post
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @PostMapping("/")
    public void getWXMessages(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        PrintWriter out = response.getWriter();

        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (Validation.checkSignature(signature, timestamp, nonce)) {
            String respXml;
            /*respXml = MessageService.dealRequest(request);
            out.print(respXml);*/
            respXml = MessageService.dealRequest(request);
            out.print(respXml);
        }
        out.flush();
        out.close();

    }
}

