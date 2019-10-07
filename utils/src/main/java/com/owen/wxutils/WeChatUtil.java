package com.owen.wxutils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.odps.udf.CodecCheck;
import com.owen.wxtoken.Access_Token;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ClassName: WeChatUtil
 * @description: 获取access_token
 * @author: zxb
 * @create: 2019-10-07 15:00
 **/
public class WeChatUtil {
    private static   Access_Token access_token;
    public static Access_Token getaccess_token(){
        JSONObject jsonObject = WxJsonUtil.httpsRequest(WxUtils.token_url, "GET", null);
        if (null!=jsonObject){
            try {
                access_token = new Access_Token(jsonObject.getString("access_token"),Integer.parseInt(jsonObject.getString("expires_in")));
            } catch (NumberFormatException e) {
                access_token = new Access_Token();
            }
        }else{
            access_token = new Access_Token();
        }
        return access_token;
    }
}