package com.owen.service.Message;


import com.owen.message.TextMessage;
import com.owen.wxutils.MessageUtil;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;

/**
 * @ClassName: MessageService
 * @description: 消息service
 * @author: zxb
 * @create: 2019-10-07 15:43
 **/
public class MessageService {
    private static Map<String, String> requestMap;

    public static String dealRequest(HttpServletRequest request) {
        //响应的XML串
        String respXml;
        //默认返回的文本消息内容
        String respContent;
        //调用parseXml方法解析请求消息
        requestMap = MessageUtil.parseXml(request);
        //发送方账号
        String fromUserName = requestMap.get("FromUserName");
        //开发者微信号
        String toUserName = requestMap.get("ToUserName");
        //消息类型
        String MsgType = requestMap.get("MsgType");
        //文本消息内容
        String Content = requestMap.get("Content");
        /*for(Map.Entry<String, String> entry : requestMap.entrySet()){
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            System.out.println(mapKey+":"+mapValue);
        }*/
        //System.out.println("用户给公众号发的消息为：" + Content);
        //构建一条文本消息

        switch (MsgType) {
            //请求消息类型：文本
            case MessageUtil.REQ_MESSAGE_TYPE_TEXT:
                respContent = "文本消息";
                break;
            //请求消息类型：图片
            case MessageUtil.REQ_MESSAGE_TYPE_IMAGE:
                respContent = "图片消息";
                break;
            //请求消息类型：语音
            case MessageUtil.REQ_MESSAGE_TYPE_VOICE:
                respContent = "语音消息";
                break;
            //请求消息类型：视频
            case MessageUtil.REQ_MESSAGE_TYPE_VIDEO:
                respContent = "视频消息";
                break;
            //请求消息类型：地理位置
            case MessageUtil.REQ_MESSAGE_TYPE_LOCATION:
                respContent = "位置消息";
                break;
            //请求消息类型：链接
            case MessageUtil.REQ_MESSAGE_TYPE_LINK:
                respContent = "连接消息";
                break;
            //请求消息类型：事件推送
            case MessageUtil.REQ_MESSAGE_TYPE_EVENT:
                respContent = getEventMessage();
                break;
            default:
                respContent = "错误的消息类型";
        }
        //事件类型
        TextMessage textMessage = new TextMessage(toUserName, fromUserName, "text", respContent, requestMap.get("MsgId"));
        respXml = MessageUtil.messageToXml(textMessage);
        return respXml;
    }

    public static String getEventMessage() {
        String str;
        String eventType = requestMap.get("Event");
        switch (eventType) {
            //事件类型：SUBSCRIBE订阅
            case MessageUtil.EVENT_TYPE_SUBSCRIBE:
                //事件类型：unsubscribe(取消订阅)
            case MessageUtil.EVENT_TYPE_UNSUBSCRIBE:
                //事件类型：scan(用户已关注时的扫描带参数的二维码)
            case MessageUtil.EVENT_TYPE_SCAN:
                //事件类型：LOCATION(上报地理位置)
            case MessageUtil.EVENT_TYPE_LOCATION:
                //事件类型：CLICK(自定义菜单)
            case MessageUtil.EVENT_TYPE_CLICK:
        }
        return "欢迎来到测试号";
    }
}