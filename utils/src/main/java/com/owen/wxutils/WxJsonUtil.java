package com.owen.wxutils;

import com.alibaba.fastjson.JSONObject;
import com.owen.user.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class WxJsonUtil {

    //日志
    private static Logger log = LoggerFactory.getLogger(WxJsonUtil.class);

    /**
     * json
     * @param requestUrl
     * @param requestMethod
     * @param outputStr
     * @return
     */
    public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        //System.out.println(requestUrl+"\n\n"+requestMethod+"\n\n"+outputStr);
        // 需要导入库json-lib-2.2.1-jdk15.jar
        JSONObject jsonObject = null;
        // 创建SSLContext对象，并使用我们指定的信任管理器初始化
        TrustManager[] tm = { new MyX509TrustManager() };
        try {
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            URL url = new URL(requestUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setSSLSocketFactory(ssf);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            // 设置请求方式（GET/POST）
            connection.setRequestMethod(requestMethod);
            if ("GET".equalsIgnoreCase(requestMethod))
                connection.connect();
            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = connection.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str;
            StringBuffer buffer = new StringBuffer();
            while ((str= bufferedReader.readLine()) != null) {
                buffer.append(str);
                jsonObject = JSONObject.parseObject(String.valueOf(buffer));
            }
            // 释放资源,返回的是token'
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            connection.disconnect();
        } catch (ConnectException e) {
            log.error("连接超时：{}", e);
        } catch (NoSuchAlgorithmException e) {
            log.error("https请求异常：{1}", e);
        } catch (NoSuchProviderException e) {
            log.error("https请求异常：{2}", e);
        } catch (KeyManagementException e) {
            log.error("https请求异常：{3}", e);
        } catch (MalformedURLException e) {
            log.error("https请求异常：{4}", e);
        } catch (IOException e) {
            log.error("https请求异常：{5}", e);
        } catch (Exception e) {
            log.error("https请求异常：{6}", e);
        }
        return jsonObject;
    }
    /**
     * 获取网页授权凭证
     * @param code
     * @return
     */
    public static Authorization getOauth2AccessToken(String code){
        Authorization authorization = null;
        String  urlstr = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+WxUtils.appID+"&secret="+WxUtils.appsecret+"&code="+code+"&grant_type=authorization_code";
        // 发起GET请求获取凭证
        JSONObject jsonObject = httpsRequest(urlstr, "GET", null);
        if (null != jsonObject) {
            try {
                authorization = new Authorization();
                authorization.setAccessToken(jsonObject.getString("access_token"));
                authorization.setExpiresIn(jsonObject.getIntValue("expires_in"));
                authorization.setRefreshToken(jsonObject.getString("refresh_token"));
                authorization.setOpenId(jsonObject.getString("openid"));
                authorization.setScope(jsonObject.getString("scope"));
            } catch (Exception e) {
                int errorCode = jsonObject.getIntValue("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                log.error("获取网页授权凭证失败 errcode:{} errmsg:{}", errorCode, errorMsg);
            }
        }
        return authorization;
    }

}
