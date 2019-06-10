package com.lrving.handle;



/**
 * 通用自定义异常，通过 RRExceptionHandler 统一处理异常的消息返回。
 */
public class RException extends RuntimeException
{
    private String  msg     = CodeEnum.UN_KNOWN.getCodeInfo();
    private int     code    = CodeEnum.UN_KNOWN.getCode();


    /**
     * 默认抛出：CodeEnum.UN_KNOWN 的异常信息。
     */
    public RException() {
    }


    /**
     * 自定义异常信息。
     */
    public RException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }


    /**
     * 通过管理的错误码类型抛出异常：如：
     *  throw new RException(CodeEnum.DATA_NOT_EXITS);
     */
    public RException(CodeEnum codeEnum) {
        this(codeEnum.getCodeInfo(), codeEnum.getCode());
    }


    ////////////////////////////////// [ get/set ] //////////////////////////////////

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
