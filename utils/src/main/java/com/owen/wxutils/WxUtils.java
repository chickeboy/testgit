package com.owen.wxutils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class WxUtils {

    //打印日志信息
    private static Logger log = LoggerFactory.getLogger(WxUtils.class);

    //第三方用户唯一凭证
    public static String appID = "wxb7a5129f755a93e3";

    //第三方用户唯一凭证密匙
    public static String appsecret = "337fc8773102c83a5b64f0352165b81b";

    //access_token URL
    public static String token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appID+"&secret="+appsecret;

    //网页授权链接
    public static String authorization = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx7cf83d973d83eb06&redirect_uri=http%3A%2F%2Fwww.qianjin.natapp1.cc%2Fauthorization_userinfo&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";

}
