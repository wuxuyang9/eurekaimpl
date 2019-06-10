package com.lrving.model;

/**
 * Created by Administrator on 2018-01-08.
 */

import com.lrving.constant.CodeEnum;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.封装json对象，所有返回结果都使用它
 * 2.code是返回码，请求成功返回0，请求失败返回错误码
 * 3.错误码参考ErrorEnum
 */
public class JsonResult {

    /**
     * 单条数据封装
     */
    public static Object success(Object data, int code) {
        Map<String, Object> result = new HashMap<>();
        result.put("data", data);
        result.put("code", code);
        return result;
    }

    /**
     * delete类型回参
     */
    public static Object success(int code) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", code);
        return result;
    }

    /**
     * list类型回参数据
     */
    public static Object success(Page page, int code) {
        Map<String, Object> result = new HashMap<>();
        /*根节点*/
        result.put("data", page.getContent());

        result.put("code", code);
        /*分页参数*/
        result.put("totalPage", page.getTotalPages());
        result.put("totalCount", page.getTotalElements());
        result.put("size", page.getSize());
        result.put("page", page.getNumber());
        return result;
    }

    /*public static Object success(Page page, Object data) {
        Map<String, Object> result = new HashMap<>();
        *//*根节点*//*
        result.put("data", data);
        result.put("code", CodeEnum.SUCCESS.getCode());
        *//*分页参数*//*
        result.put("totalPage", page.getTotalPages());
        result.put("totalCount", page.getTotalElements());
        result.put("size", page.getSize());
        result.put("page", page.getNumber());
        return result;
    }*/

    public static Object success() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", CodeEnum.SUCCESS.getCode());
        result.put("msg", CodeEnum.SUCCESS.getCodeInfo());
        return result;
    }

    public static Object success(Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put("data", data);
        result.put("code", CodeEnum.SUCCESS.getCode());
        return result;
    }

    /**
     * @methods this.success(Page page, int code)
     */
    public static Object success(Page page) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", CodeEnum.SUCCESS.getCode());
        result.put("data", page.getContent());
        result.put("totalPage", page.getTotalPages());
        result.put("totalCount", page.getTotalElements());
        result.put("size", page.getSize());
        result.put("page", page.getNumber());
        return result;
    }

    /**
     *
     * */
    public static Object error(String msg, int code) {
        Map<String, Object> result = new HashMap<>();
        result.put("msg", msg);
        result.put("code", code);
        return result;
    }

    public static Object error(CodeEnum codeEnum) {
        return error(codeEnum.getCodeInfo(), codeEnum.getCode());
    }


}
