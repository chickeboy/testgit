package com.owen.wxutils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class WxUtils {

    //打印日志信息
    private static Logger log = LoggerFactory.getLogger(WxUtils.class);

    //第三方用户唯一凭证
    public static String appID = "wx37b63deb17045620";

    //第三方用户唯一凭证密匙
    public static String appsecret = "8cd54ffa0aae23ff1222dab8d8885049";

    //Access_tokenTime URL
    public static String token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appID+"&secret="+appsecret;

    //网页授权链接
    public static String authorization = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx37b63deb17045620&redirect_uri=http://xiaozhu.natapp1.cc/SSM-WeChat/loginCode&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";

}
