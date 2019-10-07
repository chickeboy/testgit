package com.owen.wxutils;

import com.owen.message.TextMessage;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: MessageUtil
 * @description: 消息工具
 * @author: zxb
 * @create: 2019-10-07 15:45
 **/
public class MessageUtil {


    //请求消息类型：文本
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";
    //请求消息类型：图片
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";
    //请求消息类型：语音
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
    //请求消息类型：视频
    public static final String REQ_MESSAGE_TYPE_VIDEO = "video";
    //请求消息类型：地理位置
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";
    //请求消息类型：链接
    public static final String REQ_MESSAGE_TYPE_LINK = "link";
    //请求消息类型：事件推送
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";

    //---------------------------------------------------------------

    //事件类型：subscribe(订阅)
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
    //事件类型：unsubscribe(取消订阅)
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
    //事件类型：scan(用户已关注时的扫描带参数的二维码)
    public static final String EVENT_TYPE_SCAN = "scan";
    //事件类型：LOCATION(上报地理位置)
    public static final String EVENT_TYPE_LOCATION = "LOCATION";
    //事件类型：CLICK(自定义菜单)
    public static final String EVENT_TYPE_CLICK = "CLICK";

    //---------------------------------------------------------------

    //响应消息类型：文本
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";
    //响应详细类型：图片
    public static final String RESP_MESSAGE_TYPE_IMAGE = "image";
    //响应消息类型：语音
    public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
    //响应消息类型：视频
    public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
    //响应详细类型：音乐
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
    //响应消息类型：图文
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";
    private static XStream xStream = new XStream();
    /**
     * 从流中解析出每个节点的内容
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static Map<String, String> parseXml(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        //从输入流中获取流对象
        InputStream in = null;

        //构建SAX阅读器对象
        SAXReader reader = new SAXReader();
        try {
            in = request.getInputStream();
            //从流中获得文档对象

            Document doc = reader.read(in);
            //获得根节点
            Element root = doc.getRootElement();
            //获取根节点下的所有子节点
            List<Element> children = root.elements();
            for (Element e : children) {
                //遍历每一个节点，并按照节点名--节点值放入map中
                map.put(e.getName(), e.getText());
                System.out.println("用户发送的消息XML解析为：" + e.getName() + e.getText());
            }
            //关闭流
            in.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("获取用户发送数据错误");
        }
        return map;
    }
    /**
     * 将文本消息转换成XML格式
     *
     * @param textMessage
     * @return
     */
    public static String messageToXml(TextMessage textMessage) {
        xStream.alias("xml", textMessage.getClass());
        String xml = xStream.toXML(textMessage);
        System.out.println("响应所转换的XML：" + xml);
        return xml;
    }
}