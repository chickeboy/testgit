package com.owen.wxcontroller;


import com.owen.service.Message.MessageService;
import com.owen.wxutils.Validation;
import com.owen.wxutils.WxUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
            System.out.println(respXml);
            out.print(respXml);
        }
        out.flush();
        out.close();

    }
}

