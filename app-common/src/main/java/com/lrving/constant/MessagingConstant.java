package com.lrving.constant;

/**
 * Created by wangBaiChuan 2019-03-26.
 * 推送到App消息的类型。
 */
public enum MessagingConstant
{
    System_Notice(0, "推送系统公告通知，内容为WebNotice的json串"),
    ;

    private final short     code;   // 状态码。
    private final String    info;   // 描述。

    MessagingConstant(int code, String info) {
        this.code = (short) code;
        this.info = info;
    }

    public short getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
