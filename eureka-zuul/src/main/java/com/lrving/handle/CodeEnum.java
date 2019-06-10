package com.lrving.handle;


public enum CodeEnum {
    /**
     * 错误码定义规则：
     * 1.错误码长度为5位，A-BB-CCC格式
     * 2.A:表示错误级别，B:表示服务/模块名称，C:表示错误代码
     * 3.定义错误提示级别，1:为服务端返回提示、2:为不提示、3:隐藏性卖萌提示。
     * 4.定义具体的错误模块，登录相关/订单相关/产品相关
     * 5.具体错误编号，自增即可，一个项目999种错误
     * 6.code:错误编号,codeInfo:提示信息
     * 7.1-00-***为系统基础错误码，00包含基础的如权限、校验、参数缺省等错误
     * */
    SUCCESS("请求成功",0),
    SERVER_DISABLED("服务暂不可用",100001),
    UN_KNOWN("未知错误",100002),
    UN_KNOWN_METHODS("未知的方法",100003),
    IP_UNAUTHORIZED("IP未授权",100004),
    ACCESS_NO_PERMISSION("访问没有权限",100005),
    PARAMS_INVALID("请求参数无效",100006),
    API_KEY_INVALID("API KEY 无效",100007),
    ACCESS_TOKEN_INVALID("TOKEN 无效",100008),
    DATA_EXITS("数据已存在",100009),
    DATA_NOT_EXITS("数据不存在",100010),
    EXCEPTION("系统异常",100011),
    USER_VERIFY("账号或密码不正确",100012),
    DATA_CASCADE_EXITS("请删除级联数据",100013),
    DATA_EMPTY("查询数据为空",100014)
    ;


    private int code;
    private String codeInfo;

    CodeEnum() {
    }

    CodeEnum(String codeInfo, int code) {
        this.code = code;
        this.codeInfo = codeInfo;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCodeInfo() {
        return codeInfo;
    }

    public void setCodeInfo(String codeInfo) {
        this.codeInfo = codeInfo;
    }
}
