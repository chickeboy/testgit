package com.owen.wxutils;


import com.owen.wxtoken.Access_Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TokenThread {

    //日志
    private static Logger log = LoggerFactory.getLogger(TokenThread.class);

    //初始化token
    public static Access_Token access_token;

    public static Access_Token getAccess_token() {
        return TokenThread.access_token;
    }

    public static void setAccess_token(Access_Token access_token) {
        TokenThread.access_token = access_token;
    }


    /*@Override
    public void run() {
        while (true) {
            access_token = WeChatUtil.getaccess_token(appID, appsecret);
            try {
                if (null != access_token) {
                    log.info("获取access_token成功，有效时长{}秒 token:{}", access_token.getExpire_in(), access_token.getAccess_token());
                    // 休眠7000秒
                    Thread.sleep((Integer.valueOf(access_token.getExpire_in()).intValue() - 200) * 1000);
                } else {
                    //如果access_Token为null，则60秒后再获取
                    Thread.sleep(60 * 1000);
                }
            } catch (InterruptedException e) {
                // TODO: handle exception
                try {
                    Thread.sleep(60 * 1000);
                } catch (InterruptedException e2) {
                    // TODO: handle exception
                    log.error("{}", e2);
                }
                log.error("{}", e);
            }
        }
    }*/
}
