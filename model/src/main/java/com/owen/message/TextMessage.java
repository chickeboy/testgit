package com.owen.message;

/**
 * @ClassName: TextMessage
 * @description: 文本消息实体类
 * @author: zxb
 * @create: 2019-10-07 15:37
 **/
public class TextMessage extends BaseMessage{
    private String Content;
    private String MsgId;
    public TextMessage(String toUserName, String fromUserName, String msgType) {
        super(toUserName, fromUserName, msgType);
    }

    public TextMessage(String toUserName, String fromUserName, String msgType, String content, String msgId) {
        super(toUserName, fromUserName, msgType);
        Content = content;
        MsgId = msgId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
}