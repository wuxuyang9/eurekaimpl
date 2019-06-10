package com.lrving.util;


import com.lrving.constant.CodeEnum;
import com.lrving.exception.RException;

import java.util.List;

/**
 * Created by Fire945 on 2019/1/17.
 */
public class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new RException(CodeEnum.PARAMS_INVALID.getCodeInfo() + ":" + message, CodeEnum.PARAMS_INVALID.getCode());
        }
    }

    /**
     * 判断一个对象不能为 null
     * @param object    判断的对象
     * @param message   具体描述，返回时会拼接。
     *                  如：  message为：“id不能为null”, 最后会返回“请求参数无效：id不能为null”
     */
    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new RException(CodeEnum.PARAMS_INVALID.getCodeInfo() + ":" + message, CodeEnum.PARAMS_INVALID.getCode());
        }
    }
    /*public static void isNull(Object object, CodeEnum codeEnum) {
        if (object == null) {
            throw new RException(CodeEnum.PARAMS_INVALID.getCodeInfo() + ":" + message, CodeEnum.PARAMS_INVALID.getCode());
        }
    }*/
    /**
     * @param str
     * @param message
     * @param param
     */
    public static void inScope(String str, String message, Object ... param) {
        isBlank(str, message);

        for (Object par: param) {
            if (str.equals(par)) {
                return;
            }
        }
        throw new RException(CodeEnum.PARAMS_INVALID.getCodeInfo() + ":" + message, CodeEnum.PARAMS_INVALID.getCode());
    }

    /**
     *
     * @param str
     * @param message
     * @param param
     */
    public static void inScope(Object str, String message, Object ... param) {
        isNull(str, message);

        for (Object par: param) {
            if (str.equals(par)) {
                return;
            }
        }

        throw new RException(CodeEnum.PARAMS_INVALID.getCodeInfo() + ":" + message, CodeEnum.PARAMS_INVALID.getCode());
    }

    public static void inScope(List<String> str, String message, String ... param) {
        isNull(str, message);
        for (String s: str) {
            inScope(s, message, param);
        }
    }

    public static void inScope(String[] str, String message, String ... param) {
        isNull(str, message);
        for (String s: str) {
            inScope(s, message, param);
        }
    }
}
