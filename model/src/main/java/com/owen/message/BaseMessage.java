package com.owen.message;

/**
 * @ClassName: BaseMessage
 * @description: 消息父类
 * @author: zxb
 * @create: 2019-10-07 15:37
 **/
public class BaseMessage {
    private String ToUserName;
    private String FromUserName;
    private long CreateTime;
    private String MsgType;

    public BaseMessage(String toUserName, String fromUserName,String msgType) {
        ToUserName = fromUserName;
        FromUserName = toUserName;
        CreateTime = System.currentTimeMillis();
        MsgType = msgType;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }
}